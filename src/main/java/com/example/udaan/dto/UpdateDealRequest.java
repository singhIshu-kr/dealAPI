package com.example.udaan.dto;

import java.sql.Timestamp;


public class UpdateDealRequest {
    private int dealId;
    private Integer numberOfItems;
    private Timestamp endTimeStamp;

    public UpdateDealRequest(int dealId, int numberOfItems, Timestamp endTimeStamp) {
        this.dealId = dealId;
        this.numberOfItems = numberOfItems;
        this.endTimeStamp = endTimeStamp;
    }

    public int getDealId() {
        return dealId;
    }

    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    public Timestamp getEndTimeStamp() {
        return endTimeStamp;
    }
}
