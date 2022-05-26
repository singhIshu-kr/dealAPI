package com.example.udaan.entity;

import com.example.udaan.dto.DealRunningStatus;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "DealInfo")
public class DealInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int numberOfItemsToBeSold;

    private Timestamp startTimeStamp;

    private Timestamp endTimeStamp;

    private double price;

    private DealRunningStatus status = DealRunningStatus.NOT_RUNNING;

    public DealRunningStatus getStatus() {
        return status;
    }

    public void setStatus(DealRunningStatus status) {
        this.status = status;
    }


    public DealInfo(int id) {
        this.id = id;
    }

    public DealInfo() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfItemsToBeSold() {
        return numberOfItemsToBeSold;
    }

    public void setNumberOfItemsToBeSold(int numberOfItemsToBeSold) {
        this.numberOfItemsToBeSold = numberOfItemsToBeSold;
    }

    public Timestamp getStartTimeStamp() {
        return startTimeStamp;
    }

    public void setStartTimeStamp(Timestamp startTimeStamp) {
        this.startTimeStamp = startTimeStamp;
    }

    public Timestamp getEndTimeStamp() {
        return endTimeStamp;
    }

    public void setEndTimeStamp(Timestamp endTimeStamp) {
        this.endTimeStamp = endTimeStamp;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
