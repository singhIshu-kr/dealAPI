package com.example.udaan.model;

import java.util.Objects;

public class DealResponse {
    private int dealId;

    public DealResponse(int dealId) {
        this.dealId = dealId;
    }

    public int getDealId() {
        return dealId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DealResponse that = (DealResponse) o;
        return dealId == that.dealId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dealId);
    }
}
