package com.uniyaz.ui.components;

import com.uniyaz.ui.views.AddComplaintView;
import com.uniyaz.ui.views.ListComplaintView;
import com.uniyaz.ui.views.LoginView;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

public class SideBar extends VerticalLayout {

    private Header header;
    private Content content;

    private MenuButton btnLoginView;
    private MenuButton btnAddComplaint;
    private MenuButton btnListComplaint;


    public SideBar(Header header, Content content) {

        this.header = header;
        this.content = content;

        setSpacing(true);
        setMargin(true);

        btnLoginView = new MenuButton(FontAwesome.LONG_ARROW_RIGHT);
        btnLoginView.setCaption("LOGIN");
        btnLoginView.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                String username ="HOŞGELDİN";
                LoginView loginView = new LoginView();
                content.setContent(loginView);

                header.setHeaderLabel(username);
            }
        });
        addComponent(btnLoginView);

        btnAddComplaint = new MenuButton(FontAwesome.PLUS_SQUARE);
        btnAddComplaint.setCaption("ARIZA KAYDET");
        btnAddComplaint.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                AddComplaintView addComplaintView = new AddComplaintView();
                content.setContent(addComplaintView);
            }
        });

        btnListComplaint = new MenuButton(FontAwesome.LIST);
        btnListComplaint.setCaption("ARIZA LİSTELE");
        btnListComplaint.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                ListComplaintView listComplaintView = new ListComplaintView();
                content.setContent(listComplaintView);
            }
        });
        // if Giriş yapıldıysa
        addComponent(btnAddComplaint);
        addComponent(btnListComplaint);
    }
}