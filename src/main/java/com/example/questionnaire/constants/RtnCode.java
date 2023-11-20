package com.example.questionnaire.constants;

//¦CÁ|
public enum RtnCode {

	SUCCESSFUL(200, "Successful"), //
	QUESTION_PARAM_ERROR(400, "Question Param Error"), //
	QUESTIONNAIRE_PARAM_ERROR(400, "Questionnaire Param Error"), //
	QUESTIONNAIRE_ID_PARAM_ERROR(400, "Questionnaire Id Param Error"), //
	QUESTIONNAIRE_ID_NOT_FOUND(404, "Questionnaire Id not found"),//
	UPDATE_ERROR(404, "update error"),//
	
	;

	private int code;

	private String message;

	private RtnCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
