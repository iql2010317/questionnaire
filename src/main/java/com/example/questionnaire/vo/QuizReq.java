package com.example.questionnaire.vo;

import java.util.ArrayList;
import java.util.List;

import com.example.questionnaire.entity.Question;
import com.example.questionnaire.entity.Questionnaire;

//前端來的請求
public class QuizReq {

	private Questionnaire questionnaire;
	
	private List<Question> QuestionList =new ArrayList<>();

	public QuizReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuizReq(Questionnaire questionnaire, List<Question> questionList) {
		super();
		this.questionnaire = questionnaire;
		QuestionList = questionList;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public List<Question> getQuestionList() {
		return QuestionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.QuestionList = questionList;
	}
	
	
	
}
