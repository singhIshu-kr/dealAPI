package com.example.udaan.dto;

import java.sql.Timestamp;

public class Deal {
    private double price;
    private int numberOfItemsToBeSold;
    private Timestamp startTimeStamp;
    private Timestamp endTimeStamp;

    public Deal(double price, int numberOfItems, Timestamp startTimeStamp, Timestamp endTimeStamp) {
        this.price = price;
        this.numberOfItemsToBeSold = numberOfItems;
        this.startTimeStamp = startTimeStamp;
        this.endTimeStamp = endTimeStamp;
    }

    public double getPrice() {
        return price;
    }

    public int getNumberOfItemsToBeSold() {
        return numberOfItemsToBeSold;
    }

    public Timestamp getStartTimeStamp() {
        return startTimeStamp;
    }

    public Timestamp getEndTimeStamp() {
        return endTimeStamp;
    }
}
