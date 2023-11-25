package com.example.questionnaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.questionnaire.entity.HwUserResponse;

@Repository
public interface HwUserResponseDao extends JpaRepository<HwUserResponse, Integer> {

}
