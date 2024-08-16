package com.skypedal.skypedal_backend.dto;

public class MapsLocationRequest {
    private String textQuery;

    public MapsLocationRequest(String textQuery) {
        this.textQuery = textQuery;
    }

    public String getTextQuery() {
        return textQuery;
    }

    public void setTextQuery(String textQuery) {
        this.textQuery = textQuery;
    }
}
