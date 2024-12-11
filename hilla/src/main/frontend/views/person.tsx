import React from 'react';
import {AutoCrud} from '@vaadin/hilla-react-crud';
import { PersonService } from 'Frontend/generated/endpoints';
import PersonModel from "Frontend/generated/ch/martinelli/demo/fullstack/hilla/domain/PersonModel";
import {ViewConfig} from "@vaadin/hilla-file-router/types.js";

export const config: ViewConfig = {
    menu: { order: 0, icon: 'line-awesome/svg/user.svg' },
    title: 'Persons',
};

export default function ProductsView() {
    return (
        <div className='h-full'>
            <AutoCrud service={PersonService} model={PersonModel} className='h-full'/>
        </div>
    );
}
