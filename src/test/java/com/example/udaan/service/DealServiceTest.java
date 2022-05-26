package com.example.udaan.service;

import com.example.udaan.dto.Deal;
import com.example.udaan.entity.DealInfo;
import com.example.udaan.exception.DealIdNotFoundException;
import com.example.udaan.model.DealResponse;
import com.example.udaan.repository.DealRepository;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DealServiceTest {

    @Test
    void shouldCreateADealWithGivenInfo() {
        DealRepository dealRepository = mock(DealRepository.class);
        DealInfo dealInfo = new DealInfo(1);
        when(dealRepository.save(any())).thenReturn(dealInfo);

        DealService dealService = new DealService(dealRepository);
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusDays(1);
        Deal deal = new Deal(100, 2, Timestamp.valueOf(startTime), Timestamp.valueOf(endTime));

        DealResponse createDealResponse = dealService.createDeal(deal);
        assertEquals(new DealResponse(1), createDealResponse);
    }

    @Test
    void shouldEndADealWhenGivenDealId() {
        DealRepository dealRepository = mock(DealRepository.class);
        DealInfo dealInfo = new DealInfo(1);
        DealInfo currentDeal = new DealInfo(1);
        when(dealRepository.findById(1)).thenReturn(Optional.of(currentDeal));
        when(dealRepository.save(any())).thenReturn(dealInfo);

        DealService dealService = new DealService(dealRepository);
        DealResponse createDealResponse = dealService.endADeal(1);
        assertEquals(new DealResponse(1), createDealResponse);
    }

    @Test
    void shouldThrowDealNotFoundExceptionWhenDealIsNotPresent() {
        DealRepository dealRepository = mock(DealRepository.class);
        when(dealRepository.findById(1)).thenReturn(Optional.empty());

        DealService dealService = new DealService(dealRepository);

        DealIdNotFoundException dealIdNotFoundException = assertThrows(DealIdNotFoundException.class, () -> {
            dealService.endADeal(1);
        });

        assertEquals("Given dealId does'nt exist", dealIdNotFoundException.getMessage());
    }
}
