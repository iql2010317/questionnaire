package com.example.questionnaire.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hw_questionnaire")
public class HwQuestionnaire {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="questionnaire_id")
	private int questionnaireId;
	
	@Column(name="question_name")
	private String questionName;
	
	@Column(name="description")
	private String description;
	
	@Column(name="start_time")
	private LocalDate startTime;
	
	@Column(name="end_time")
	private LocalDate endTime;

	@Column(name="is_published")
	private boolean published;

	public HwQuestionnaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HwQuestionnaire(int questionnaireId, String questionName, String description, LocalDate startTime,
			LocalDate endTime, boolean published) {
		super();
		this.questionnaireId = questionnaireId;
		this.questionName = questionName;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.published = published;
	}
	
	public HwQuestionnaire(String questionName, String description, LocalDate startTime,
			LocalDate endTime, boolean published) {
		super();
		this.questionName = questionName;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.published = published;
	}
	

	public int getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(int questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDate startTime) {
		this.startTime = startTime;
	}

	public LocalDate getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDate endTime) {
		this.endTime = endTime;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}
	
}
