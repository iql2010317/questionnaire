package com.example.questionnaire.service.ifs;

import java.time.LocalDate;

import com.example.questionnaire.vo.HwQuestionnaireRequest;
import com.example.questionnaire.vo.HwQuestionnaireResponse;

public interface HwQuestionnaireService {

	public HwQuestionnaireResponse create(HwQuestionnaireRequest req);

	public HwQuestionnaireResponse search();

	public HwQuestionnaireResponse searchParam(String questionName);

	public HwQuestionnaireResponse searchParamTime(String questionName, LocalDate startTime, LocalDate endTime);

	public HwQuestionnaireResponse getQuestionnaireInfoById(int questionnaireId);
}
