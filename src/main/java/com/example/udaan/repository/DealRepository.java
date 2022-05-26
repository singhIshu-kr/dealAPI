package com.example.udaan.repository;

import com.example.udaan.entity.DealInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealRepository extends JpaRepository<DealInfo, Integer> {
}
