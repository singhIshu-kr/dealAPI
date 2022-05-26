package com.example.udaan.controller;

import com.example.udaan.dto.Deal;
import com.example.udaan.dto.EndADealRequest;
import com.example.udaan.dto.UpdateDealRequest;
import com.example.udaan.model.DealResponse;
import com.example.udaan.service.DealService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deal")
public class DealController {

    private DealService dealService;

    public DealController(DealService dealService) {
        this.dealService = dealService;
    }

    @PostMapping
    public ResponseEntity<DealResponse> createDeal(@RequestBody Deal deal) {
        DealResponse createdDeal = dealService.createDeal(deal);
        return new ResponseEntity(createdDeal, HttpStatus.CREATED);
    }

    @PutMapping("/end")
    public ResponseEntity<DealResponse> endADeal(
            @RequestBody EndADealRequest endADealRequest) {
        DealResponse endADeal = dealService.endADeal(endADealRequest.getDealId());
        return new ResponseEntity(endADeal, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<DealResponse> updateADeal(@RequestBody UpdateDealRequest updateDealRequest) {
        DealResponse endADeal = dealService.updateADeal(updateDealRequest);
        return new ResponseEntity(endADeal, HttpStatus.OK);
    }
}
