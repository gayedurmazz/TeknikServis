package com.uniyaz.ui.views;

import com.uniyaz.rest.RestClient;
import com.uniyaz.rest.dto.ComplaintDto;
import com.uniyaz.rest.dto.UserDto;
import com.uniyaz.ui.components.SaveButton;
import com.vaadin.ui.*;

public class AddComplaintView extends VerticalLayout {

    private VerticalLayout mainLayout;
    private TextField idField;
    private TextField clientNameSurnameField;
    private TextArea complaintField;
    private TextArea explanationField;
//    private ComboBox stateField;
    private DateField complaintDateField;
    private SaveButton btnSaveComplaint;
    public AddComplaintView() {
        mainLayout = new VerticalLayout();
        addComponent(mainLayout);

        idField = new TextField();
        idField.setCaption("Arıza Kayıt Id");
        mainLayout.addComponent(idField);

        clientNameSurnameField = new TextField();
        clientNameSurnameField.setCaption("Müşteri Adı Soyadı");
        mainLayout.addComponent(clientNameSurnameField);

        complaintDateField = new DateField();
        complaintDateField.setCaption("Tarih");

        mainLayout.addComponent(complaintDateField);
        complaintField = new TextArea();
        complaintField.setCaption("Arıza Tanımı");
        mainLayout.addComponent(complaintField);

        explanationField = new TextArea();
        explanationField.setCaption("Açıklama");
        mainLayout.addComponent(explanationField);

        btnSaveComplaint = new SaveButton();
        mainLayout.addComponent(btnSaveComplaint);
        btnSaveComplaint.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                RestClient restClient = new RestClient();

                ComplaintDto complaintDto = new ComplaintDto();
                complaintDto.setClientNameSurname(clientNameSurnameField.getValue());
                complaintDto.setComplaint(complaintField.getValue());
                complaintDto.setExplanation(explanationField.getValue());

                restClient.callSaveComplaintService(complaintDto);

                Notification.show("Arıza Kaydı Eklendi");
            }
        });
    }
}
