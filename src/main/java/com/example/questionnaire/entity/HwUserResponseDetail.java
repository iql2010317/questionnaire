package com.example.questionnaire.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hw_user_response_detail")
public class HwUserResponseDetail {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "response_detail_id")
	private int responseDetailId;
	
	@Column(name = "response_id")
	private int responseId;
	
	@Column(name = "question_id")
	private int questionId;
	
	@Column(name = "answer_text")
	private String answerText;

	public HwUserResponseDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HwUserResponseDetail(int responseDetailId, int responseId, int questionId, String answerText) {
		super();
		this.responseDetailId = responseDetailId;
		this.responseId = responseId;
		this.questionId = questionId;
		this.answerText = answerText;
	}

	public int getResponseDetailId() {
		return responseDetailId;
	}

	public void setResponseDetailId(int responseDetailId) {
		this.responseDetailId = responseDetailId;
	}

	public int getResponseId() {
		return responseId;
	}

	public void setResponseId(int responseId) {
		this.responseId = responseId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
	
	
	
	
	
}
