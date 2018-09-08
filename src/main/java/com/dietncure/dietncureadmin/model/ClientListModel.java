package com.dietncure.dietncureadmin.model;

public class ClientListModel {
    private String clientName;

    public ClientListModel(String clientName) {
        this.clientName = clientName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
