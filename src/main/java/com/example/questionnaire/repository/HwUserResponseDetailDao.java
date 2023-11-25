package com.example.questionnaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.questionnaire.entity.HwUserResponseDetail;

@Repository
public interface HwUserResponseDetailDao extends JpaRepository<HwUserResponseDetail, Integer> {

}
