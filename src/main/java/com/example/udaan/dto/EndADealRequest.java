package com.example.udaan.dto;

public class EndADealRequest {
    private int dealId;

    public EndADealRequest(int dealId) {
        this.dealId = dealId;
    }

    public int getDealId() {
        return dealId;
    }
}
