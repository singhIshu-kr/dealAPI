package com.example.udaan.controller;

import com.example.udaan.dto.Deal;
import com.example.udaan.dto.EndADealRequest;
import com.example.udaan.dto.UpdateDealRequest;
import com.example.udaan.model.DealResponse;
import com.example.udaan.service.DealService;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class DealControllerTest {

    @Test
    void shouldCreateADealAndSendTheDealId() {
        DealService dealService = mock(DealService.class);
        DealController dealController = new DealController(dealService);
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusDays(1);
        Deal deal = new Deal(100, 2, Timestamp.valueOf(startTime), Timestamp.valueOf(endTime));
        DealResponse createDealResponse = new DealResponse(1);

        when(dealService.createDeal(deal)).thenReturn(createDealResponse);
        ResponseEntity<DealResponse> responseEntity = dealController.createDeal(deal);
        assertEquals(responseEntity.getBody(), createDealResponse);
    }

    @Test
    void shouldEndADealAndSendDealId() {
        DealService dealService = mock(DealService.class);
        DealController dealController = new DealController(dealService);

        DealResponse dealResponse = new DealResponse(1);
        when(dealService.endADeal(1)).thenReturn(dealResponse);
        EndADealRequest endADealRequest = new EndADealRequest(1);
        ResponseEntity<DealResponse> responseEntity = dealController.endADeal(endADealRequest);
        assertEquals(responseEntity.getBody(), dealResponse);
    }

    @Test
    void shouldUpdateTheDealWithGivenInfo() {
        DealService dealService = mock(DealService.class);
        DealController dealController = new DealController(dealService);

        DealResponse dealResponse = new DealResponse(1);
        UpdateDealRequest updateDealRequest = new UpdateDealRequest(1,
                100, Timestamp.valueOf(LocalDateTime.now()));
        when(dealService.updateADeal(updateDealRequest)).thenReturn(dealResponse);
        ResponseEntity<DealResponse> responseEntity = dealController.updateADeal(updateDealRequest);
        assertEquals(responseEntity.getBody(), dealResponse);
    }
}
