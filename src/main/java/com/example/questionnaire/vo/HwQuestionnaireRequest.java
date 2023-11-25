package com.example.questionnaire.vo;

import java.util.ArrayList;
import java.util.List;

import com.example.questionnaire.entity.HwQuestion;
import com.example.questionnaire.entity.HwQuestionnaire;

public class HwQuestionnaireRequest {

	private HwQuestionnaire hwQuestionnaire; //可以當成vo使用?

	private List<HwQuestion> hwQuestionList = new ArrayList<>();

	public HwQuestionnaireRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HwQuestionnaireRequest(HwQuestionnaire hwQuestionnaire, List<HwQuestion> hwQuestionList) {
		super();
		this.hwQuestionnaire = hwQuestionnaire;
		this.hwQuestionList = hwQuestionList;
	}

	public HwQuestionnaire getHwQuestionnaire() {
		return hwQuestionnaire;
	}

	public void setHwQuestionnaire(HwQuestionnaire hwQuestionnaire) {
		this.hwQuestionnaire = hwQuestionnaire;
	}

	public List<HwQuestion> getHwQuestionList() {
		return hwQuestionList;
	}

	public void setHwQuestionList(List<HwQuestion> hwQuestionList) {
		this.hwQuestionList = hwQuestionList;
	}

}
