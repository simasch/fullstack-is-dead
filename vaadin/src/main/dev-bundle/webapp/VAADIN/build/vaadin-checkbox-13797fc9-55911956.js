import{y as a,k as r,U as e,m as c,F as o}from"./indexhtml-e4271a8f.js";const t={selector:"vaadin-checkbox",displayName:"Checkbox",properties:[{propertyName:"--vaadin-checkbox-size",displayName:"Checkbox size",defaultValue:"var(--lumo-font-size-l)",editorType:a.range,presets:r.lumoFontSize,icon:"square"}]},s={selector:"vaadin-checkbox::part(checkbox)",displayName:"Checkmark box",properties:[e.backgroundColor,e.borderColor,e.borderWidth,e.borderRadius]},l={selector:"vaadin-checkbox[checked]::part(checkbox)",stateAttribute:"checked",displayName:"Checkmark box (when checked)",properties:[e.backgroundColor,e.borderColor,e.borderWidth,e.borderRadius]},i={selector:"vaadin-checkbox::part(checkbox)::after",displayName:"Checkmark",properties:[c.iconColor]},d={selector:"vaadin-checkbox label",displayName:"Label",properties:[o.textColor,o.fontSize,o.fontWeight,o.fontStyle]},b={tagName:"vaadin-checkbox",displayName:"Checkbox",elements:[t,s,l,i,d]};export{s as checkboxElement,l as checkedCheckboxElement,i as checkmarkElement,b as default,t as hostElement,d as labelElement};
