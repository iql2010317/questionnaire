package com.example.questionnaire.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hw_question")
public class HwQuestion {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "question_id")
	private int questionId;

	@Column(name = "questionnaire_id")
	private int questionnaireId;
	
	@Column(name = "question_type")
	private String questionType;
	
	@Column(name="is_necessary")
	private boolean necessary;
	
	@Column(name = "question_text")
	private String questionText;
	
	@Column(name = "option_text")
	private String optionText;

	public HwQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HwQuestion(int questionId, int questionnaireId, String questionType, boolean necessary, String questionText,
			String optionText) {
		super();
		this.questionId = questionId;
		this.questionnaireId = questionnaireId;
		this.questionType = questionType;
		this.necessary = necessary;
		this.questionText = questionText;
		this.optionText = optionText;
	}
	
	public HwQuestion(String questionType, boolean necessary, String questionText,
			String optionText) {
		super();
		this.questionType = questionType;
		this.necessary = necessary;
		this.questionText = questionText;
		this.optionText = optionText;
	}
	

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(int questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public boolean isNecessary() {
		return necessary;
	}

	public void setNecessary(boolean necessary) {
		this.necessary = necessary;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getOptionText() {
		return optionText;
	}

	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}
}
