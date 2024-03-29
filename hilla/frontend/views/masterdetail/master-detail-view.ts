import {Binder, field} from '@hilla/form';
import {EndpointError} from '@hilla/frontend';
import '@vaadin/button';
import '@vaadin/date-picker';
import '@vaadin/date-time-picker';
import '@vaadin/form-layout';
import '@vaadin/grid';
import type {Grid, GridDataProviderCallback, GridDataProviderParams} from '@vaadin/grid';
import {columnBodyRenderer} from '@vaadin/grid/lit';
import '@vaadin/grid/vaadin-grid-sort-column';
import '@vaadin/horizontal-layout';
import '@vaadin/icon';
import '@vaadin/icons';
import '@vaadin/notification';
import {Notification} from '@vaadin/notification';
import '@vaadin/polymer-legacy-adapter';
import '@vaadin/split-layout';
import '@vaadin/text-field';
import '@vaadin/upload';
import Person from 'Frontend/generated/ch/martinelli/demo/fullstack/data/entity/Person';
import PersonModel from 'Frontend/generated/ch/martinelli/demo/fullstack/data/entity/PersonModel';
import type Sort from 'Frontend/generated/dev/hilla/mappedtypes/Sort.js';
import Direction from 'Frontend/generated/org/springframework/data/domain/Sort/Direction.js';
import * as PersonEndpoint from 'Frontend/generated/PersonEndpoint';
import {html} from 'lit';
import {customElement, property, query} from 'lit/decorators.js';
import {View} from '../view.js';

@customElement('master-detail-view')
export class MasterDetailView extends View {
  @query('#grid')
  private grid!: Grid;

  @property({ type: Number })
  private gridSize = 0;

  private gridDataProvider = this.getGridData.bind(this);

  private binder = new Binder<PersonModel>(this, PersonModel);

  render() {
    return html`
      <vaadin-split-layout>
        <div class="grid-wrapper">
          <vaadin-grid
            id="grid"
            theme="no-border"
            .size=${this.gridSize}
            .dataProvider=${this.gridDataProvider}
            @active-item-changed=${this.itemSelected}
          >
            <vaadin-grid-sort-column path="firstName" auto-width></vaadin-grid-sort-column>
            <vaadin-grid-sort-column path="lastName" auto-width></vaadin-grid-sort-column>
            <vaadin-grid-sort-column path="email" auto-width></vaadin-grid-sort-column>
            <vaadin-grid-sort-column path="phone" auto-width></vaadin-grid-sort-column>
            <vaadin-grid-sort-column path="dateOfBirth" auto-width></vaadin-grid-sort-column>
            <vaadin-grid-sort-column path="occupation" auto-width></vaadin-grid-sort-column>
            <vaadin-grid-sort-column path="role" auto-width></vaadin-grid-sort-column>
            <vaadin-grid-column
              path="important"
              auto-width
              ${columnBodyRenderer<Person>((item) =>
                item.important
                  ? html`<vaadin-icon
                      icon="vaadin:check"
                      style="width: var(--lumo-icon-size-s); height: var(--lumo-icon-size-s); color: var(--lumo-primary-text-color);"
                    >
                    </vaadin-icon>`
                  : html`<vaadin-icon
                      icon="vaadin:minus"
                      style="width: var(--lumo-icon-size-s); height: var(--lumo-icon-size-s); color: var(--lumo-disabled-text-color);"
                    >
                    </vaadin-icon>`
              )}
            ></vaadin-grid-column>
          </vaadin-grid>
        </div>
        <div class="editor-layout">
          <div class="editor">
            <vaadin-form-layout
              ><vaadin-text-field
                label="First name"
                id="firstName"
                ${field(this.binder.model.firstName)}
              ></vaadin-text-field
              ><vaadin-text-field
                label="Last name"
                id="lastName"
                ${field(this.binder.model.lastName)}
              ></vaadin-text-field
              ><vaadin-text-field label="Email" id="email" ${field(this.binder.model.email)}></vaadin-text-field
              ><vaadin-text-field label="Phone" id="phone" ${field(this.binder.model.phone)}></vaadin-text-field
              ><vaadin-date-picker
                label="Date of birth"
                id="dateOfBirth"
                ${field(this.binder.model.dateOfBirth)}
              ></vaadin-date-picker
              ><vaadin-text-field
                label="Occupation"
                id="occupation"
                ${field(this.binder.model.occupation)}
              ></vaadin-text-field
              ><vaadin-text-field label="Role" id="role" ${field(this.binder.model.role)}></vaadin-text-field
              ><vaadin-checkbox id="important" ${field(this.binder.model.important)} label="Important"></vaadin-checkbox
            ></vaadin-form-layout>
          </div>
          <vaadin-horizontal-layout class="button-layout">
            <vaadin-button theme="primary" @click=${this.save}>Save</vaadin-button>
            <vaadin-button theme="tertiary" @click=${this.cancel}>Cancel</vaadin-button>
          </vaadin-horizontal-layout>
        </div>
      </vaadin-split-layout>
    `;
  }

  private async getGridData(
    params: GridDataProviderParams<Person>,
    callback: GridDataProviderCallback<Person | undefined>
  ) {
    const sort: Sort = {
      orders: params.sortOrders.map((order) => ({
        property: order.path,
        direction: order.direction == 'asc' ? Direction.ASC : Direction.DESC,
        ignoreCase: false,
      })),
    };
    const data = await PersonEndpoint.list({ pageNumber: params.page, pageSize: params.pageSize, sort });
    callback(data);
  }

  async connectedCallback() {
    super.connectedCallback();
    this.gridSize = (await PersonEndpoint.count()) ?? 0;
  }

  private async itemSelected(event: CustomEvent) {
    const item: Person = event.detail.value as Person;
    this.grid.selectedItems = item ? [item] : [];

    if (item) {
      const fromBackend = await PersonEndpoint.get(item.id!);
      fromBackend ? this.binder.read(fromBackend) : this.refreshGrid();
    } else {
      this.clearForm();
    }
  }

  private async save() {
    try {
      const isNew = !this.binder.value.id;
      await this.binder.submitTo(PersonEndpoint.update);
      if (isNew) {
        // We added a new item
        this.gridSize++;
      }
      this.clearForm();
      this.refreshGrid();
      Notification.show(`Person details stored.`, { position: 'bottom-start' });
    } catch (error: any) {
      if (error instanceof EndpointError) {
        Notification.show(`Server error. ${error.message}`, { theme: 'error', position: 'bottom-start' });
      } else {
        throw error;
      }
    }
  }

  private cancel() {
    this.grid.activeItem = undefined;
  }

  private clearForm() {
    this.binder.clear();
  }

  private refreshGrid() {
    this.grid.selectedItems = [];
    this.grid.clearCache();
  }
}
