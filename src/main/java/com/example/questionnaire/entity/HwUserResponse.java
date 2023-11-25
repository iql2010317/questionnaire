package com.example.questionnaire.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hw_user_response")
public class HwUserResponse {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "response_id")
	private int responseId;

	@Column(name = "questionnaire_id")
	private int questionnaireId;

	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "user_email")
	private String userEmail;
	
	@Column(name = "user_phone")
	private String userPhone;
	
	@Column(name = "user_age")
	private int userAge;

	public HwUserResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HwUserResponse(int responseId, int questionnaireId, String userName, String userEmail, String userPhone,
			int userAge) {
		super();
		this.responseId = responseId;
		this.questionnaireId = questionnaireId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userAge = userAge;
	}

	public int getResponseId() {
		return responseId;
	}

	public void setResponseId(int responseId) {
		this.responseId = responseId;
	}

	public int getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(int questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	
	
	
	
	

}
