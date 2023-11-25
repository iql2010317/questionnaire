package com.example.questionnaire.vo;

import java.util.List;

import com.example.questionnaire.constants.RtnCode;
import com.example.questionnaire.entity.HwQuestion;
import com.example.questionnaire.entity.HwQuestionnaire;

public class HwQuestionnaireResponse {

	private List<HwQuestionnaire> hwQuestionnaireList;

	private List<HwQuestion> hwQuestionList;

	private RtnCode rtnCode;

	public HwQuestionnaireResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 三個
	public HwQuestionnaireResponse(List<HwQuestionnaire> hwQuestionnaireList, List<HwQuestion> hwQuestionList,
			RtnCode rtnCode) {
		super();
		this.hwQuestionnaireList = hwQuestionnaireList;
		this.hwQuestionList = hwQuestionList;
		this.rtnCode = rtnCode;
	}

	// 兩個
	public HwQuestionnaireResponse(List<HwQuestionnaire> hwQuestionnaireList, RtnCode rtnCode) {
		super();
		this.hwQuestionnaireList = hwQuestionnaireList;
		this.rtnCode = rtnCode;
	}

	// 一個
	public HwQuestionnaireResponse(RtnCode rtnCode) {
		super();
		this.rtnCode = rtnCode;
	}
	

	public List<HwQuestionnaire> getHwQuestionnaireList() {
		return hwQuestionnaireList;
	}

	public void setHwQuestionnaireList(List<HwQuestionnaire> hwQuestionnaireList) {
		this.hwQuestionnaireList = hwQuestionnaireList;
	}

	public List<HwQuestion> getHwQuestionList() {
		return hwQuestionList;
	}

	public void setHwQuestionList(List<HwQuestion> hwQuestionList) {
		this.hwQuestionList = hwQuestionList;
	}

	public RtnCode getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(RtnCode rtnCode) {
		this.rtnCode = rtnCode;
	}

}
