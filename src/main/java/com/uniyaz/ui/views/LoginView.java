package com.uniyaz.ui.views;

import com.uniyaz.rest.RestClient;
import com.uniyaz.ui.components.MenuButton;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;

public class LoginView extends VerticalLayout {

    FormLayout mainLayout;
    public LoginView() {

        mainLayout = new FormLayout();
        addComponent(mainLayout);

        TextField usernameField = new TextField("Username");
        mainLayout.addComponent(usernameField);

        PasswordField passwordField= new PasswordField("Password");
        mainLayout.addComponent(passwordField);

        MenuButton loginButton = new MenuButton(FontAwesome.LONG_ARROW_RIGHT);
        loginButton.setCaption("LOGIN");
        loginButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                RestClient restClient = new RestClient();
                restClient.callLoginService(usernameField.getValue(), passwordField.getValue());

                Notification.show("Giriş Yapıldı");
            }
        });
        mainLayout.addComponent(loginButton);
    }
}
