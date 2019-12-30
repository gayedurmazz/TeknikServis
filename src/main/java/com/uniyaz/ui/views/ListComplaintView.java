package com.uniyaz.ui.views;

import com.uniyaz.rest.RestClient;
import com.uniyaz.rest.dto.ComplaintDto;
import com.uniyaz.rest.dto.EnumState;
import com.uniyaz.ui.components.MenuButton;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.MultiSelectMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import java.util.Date;
import java.util.List;

public class ListComplaintView extends VerticalLayout {

    private Table table;

    private IndexedContainer indexedContainer;
    private AddComplaintView addComplaintView;

    public ListComplaintView() {

        TextField clientNameField = new TextField("Aranacak Müşteri Adı");
        addComponent(clientNameField);

        MenuButton searchButton = new MenuButton(FontAwesome.SEARCH);
        searchButton.setCaption("ARA");
        searchButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                fillTable(clientNameField.getValue());
            }
        });
        addComponent(searchButton);

        buildTableContainer();

        buildTable();
        addComponent(table);

        addComplaintView = new AddComplaintView();
        addComponent(addComplaintView);
    }

    private void fillTable(String clientNameFieldValue) {


        RestClient restClient = new RestClient();
        List<ComplaintDto> complaintDtoList = restClient.callListComplaintByClientNameService(clientNameFieldValue);
        for (ComplaintDto complaintDto : complaintDtoList) {
            Item item = indexedContainer.addItem(complaintDto);
            item.getItemProperty("id").setValue(complaintDto.getId());
            item.getItemProperty("complaintDate").setValue(complaintDto.getComplaintDate());
            item.getItemProperty("clientNameSurname").setValue(complaintDto.getClientNameSurname());
            item.getItemProperty("complaint").setValue(complaintDto.getComplaint());
            item.getItemProperty("enumState").setValue(complaintDto.getEnumState());
            item.getItemProperty("explanation").setValue(complaintDto.getExplanation());

        }
    }

    private void buildTableContainer() {

        indexedContainer = new IndexedContainer();
        indexedContainer.addContainerProperty("id", Integer.class, null);
        indexedContainer.addContainerProperty("complaintDate", Date.class, null);
        indexedContainer.addContainerProperty("clientNameSurname", String.class, null);
        indexedContainer.addContainerProperty("complaint", String.class, null);
        indexedContainer.addContainerProperty("enumState", EnumState.class, null);
        indexedContainer.addContainerProperty("explanation", String.class, null);
    }

    private void buildTable() {
        table = new Table();

        table.setContainerDataSource(indexedContainer);
        table.setColumnHeaders("ID","ARIZA KAYIT TARİHİ", "MÜŞTERİ ADI", "ARIZA TANIMI","GİDERİLME DURUMU","SERVİS AÇIKLAMASI");
        table.setSelectable(true);
        table.setMultiSelectMode(MultiSelectMode.SIMPLE);
        table.setMultiSelect(false);

        table.addItemClickListener(new ItemClickEvent.ItemClickListener() {
            @Override
            public void itemClick(ItemClickEvent itemClickEvent) {
//                issue = (Issue) itemClickEvent.getItemId();
//
//                addIssueView.fillViewByIssue(issue);
            }
        });
    }
}
