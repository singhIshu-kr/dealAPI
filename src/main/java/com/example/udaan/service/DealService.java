package com.example.udaan.service;

import com.example.udaan.dto.Deal;
import com.example.udaan.dto.DealRunningStatus;
import com.example.udaan.dto.UpdateDealRequest;
import com.example.udaan.entity.DealInfo;
import com.example.udaan.exception.DealIdNotFoundException;
import com.example.udaan.model.DealResponse;
import com.example.udaan.repository.DealRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DealService {

    private DealRepository dealRepository;
    private ObjectMapper objectMapper = new ObjectMapper();

    public DealService(DealRepository dealRepository) {
        this.dealRepository = dealRepository;
    }

    public DealResponse createDeal(Deal deal) {
        DealInfo dealInfo = objectMapper.convertValue(deal, DealInfo.class);
        DealInfo savedDealerInfo = dealRepository.save(dealInfo);

        return new DealResponse(savedDealerInfo.getId());
    }

    public DealResponse endADeal(int dealId) {
        Optional<DealInfo> dealInfo = dealRepository.findById(dealId);
        validateDealId(dealInfo);
        DealInfo currentDeal = objectMapper.convertValue(dealInfo.get(), DealInfo.class);
        currentDeal.setStatus(DealRunningStatus.NOT_RUNNING);
        DealInfo updatedDeal = dealRepository.save(currentDeal);
        return new DealResponse(updatedDeal.getId());

    }

    public DealResponse updateADeal(UpdateDealRequest updateDealRequest) {

        Optional<DealInfo> dealInfo = dealRepository.findById(updateDealRequest.getDealId());
        validateDealId(dealInfo);
        DealInfo currentDeal = objectMapper.convertValue(dealInfo.get(), DealInfo.class);
        if (updateDealRequest.getEndTimeStamp() != null) {
            currentDeal.setEndTimeStamp(updateDealRequest.getEndTimeStamp());
        }
        if (updateDealRequest.getNumberOfItems() != null) {
            currentDeal.setNumberOfItemsToBeSold(updateDealRequest.getNumberOfItems());
        }
        DealInfo updatedDeal = dealRepository.save(currentDeal);
        return new DealResponse(updatedDeal.getId());
    }

    private void validateDealId(Optional<DealInfo> dealInfo) {
        if (!dealInfo.isPresent()) {
            throw new DealIdNotFoundException("Given dealId does'nt exist");
        }
    }
}
