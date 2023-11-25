package com.example.questionnaire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.questionnaire.entity.HwQuestion;

@Repository
public interface HwQuestionDao extends JpaRepository<HwQuestion, Integer> {

	List<HwQuestion> findByQuestionnaireId(int questionnaireId);

}
