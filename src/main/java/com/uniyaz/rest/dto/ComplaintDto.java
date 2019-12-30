package com.uniyaz.rest.dto;

import java.util.Date;

public class ComplaintDto {


    private int id;
    private String clientNameSurname;
    private String complaint;
    private Date complaintDate;
    private EnumState enumState;
    private String explanation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientNameSurname() {
        return clientNameSurname;
    }

    public void setClientNameSurname(String clientNameSurname) {
        this.clientNameSurname = clientNameSurname;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public Date getComplaintDate() {
        return complaintDate;
    }

    public void setComplaintDate(Date complaintDate) {
        this.complaintDate = complaintDate;
    }

    public EnumState getEnumState() {
        return enumState;
    }

    public void setEnumState(EnumState enumState) {
        this.enumState = enumState;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
