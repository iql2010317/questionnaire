package com.example.questionnaire.vo;

import java.util.List;

import com.example.questionnaire.constants.RtnCode;
import com.example.questionnaire.entity.Questionnaire;

public class QuestionnaireRes {

	private List<Questionnaire> questionnaireList;
	
	private RtnCode rtnCode;

	public QuestionnaireRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionnaireRes(List<Questionnaire> questionnaireList, RtnCode rtnCode) {
		super();
		this.questionnaireList = questionnaireList;
		this.rtnCode = rtnCode;
	}

	public List<Questionnaire> getQuestionnaireList() {
		return questionnaireList;
	}

	public void setQuestionnaireList(List<Questionnaire> questionnaireList) {
		this.questionnaireList = questionnaireList;
	}

	public RtnCode getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(RtnCode rtnCode) {
		this.rtnCode = rtnCode;
	}
	
	
}
