package com.example.questionnaire.service.ifs;

import java.time.LocalDate;
import java.util.List;

import com.example.questionnaire.vo.QuizReq;
import com.example.questionnaire.vo.QuizRes;

public interface QuizService {

	public QuizRes create(QuizReq req);

	public QuizRes update(QuizReq req);

	public QuizRes deleteQuestionnaire(List<Integer> qnidList);

	public QuizRes deleteQuestion(int qnId, List<Integer> qnidList);

	public QuizRes search(String title, LocalDate startDate, LocalDate endDate);
	
//	public QuizRes searchQuestionnaireList(String title, LocalDate startDate, LocalDate endDate);
}
