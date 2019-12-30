package com.uniyaz.ui.components;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class Header extends VerticalLayout {

    private Label headerLabel = new Label();
    public Header() {
        setWidth(100, Unit.PERCENTAGE);
        setHeight(100, Unit.PIXELS);
    }

    public void setHeaderLabel(String caption) {
        headerLabel.setCaption(caption);
        headerLabel.setStyleName(ValoTheme.TEXTAREA_ALIGN_CENTER);
        headerLabel.setStyleName(ValoTheme.LABEL_BOLD);
        addComponent(headerLabel);
    }
}
