package com.example.questionnaire.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.questionnaire.entity.HwQuestionnaire;

@Repository
public interface HwQuestionnaireDao extends JpaRepository<HwQuestionnaire, Integer> {

	List<HwQuestionnaire> findByQuestionNameContaining(String questionName);

	List<HwQuestionnaire> findByQuestionNameContainingAndStartTimeGreaterThanEqualAndEndTimeLessThanEqual(
			String questionName, LocalDate startTime, LocalDate endTime);

	List<HwQuestionnaire> findByStartTimeGreaterThanEqualAndEndTimeLessThanEqual(LocalDate effectiveStartTime,
			LocalDate effectiveEndTime);

}
