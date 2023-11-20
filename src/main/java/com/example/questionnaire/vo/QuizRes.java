package com.example.questionnaire.vo;

import java.util.List;

import com.example.questionnaire.constants.RtnCode;

public class QuizRes {
	
	//利用組合 寫出更好的寫法
	private List<QuizVo> quizVoList;

	private RtnCode rtnCode;

	public QuizRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuizRes(RtnCode rtnCode) {
		super();
		this.rtnCode = rtnCode;
	}

	public RtnCode getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(RtnCode rtnCode) {
		this.rtnCode = rtnCode;
	}

	public QuizRes(List<QuizVo> quizVoList, RtnCode rtnCode) {
		super();
		this.quizVoList = quizVoList;
		this.rtnCode = rtnCode;
	}

	public List<QuizVo> getQuizVoList() {
		return quizVoList;
	}

	public void setQuizVoList(List<QuizVo> quizVoList) {
		this.quizVoList = quizVoList;
	}

	
	
}
