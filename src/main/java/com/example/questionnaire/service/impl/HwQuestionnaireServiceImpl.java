package com.example.questionnaire.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.questionnaire.constants.RtnCode;
import com.example.questionnaire.entity.HwQuestion;
import com.example.questionnaire.entity.HwQuestionnaire;
import com.example.questionnaire.repository.HwQuestionDao;
import com.example.questionnaire.repository.HwQuestionnaireDao;
import com.example.questionnaire.service.ifs.HwQuestionnaireService;
import com.example.questionnaire.vo.HwQuestionnaireRequest;
import com.example.questionnaire.vo.HwQuestionnaireResponse;

@Service
public class HwQuestionnaireServiceImpl implements HwQuestionnaireService {

	@Autowired
	private HwQuestionnaireDao hwQuestionnaireDao;

	@Autowired
	private HwQuestionDao hwQuestionDao;

	@Override
	public HwQuestionnaireResponse create(HwQuestionnaireRequest req) {

		HwQuestionnaire questionnaire = req.getHwQuestionnaire();
		List<HwQuestion> questionList = req.getHwQuestionList();

		HwQuestionnaire savedQuestionnaire = hwQuestionnaireDao.save(questionnaire);

		for (HwQuestion question : questionList) {
			question.setQuestionnaireId(savedQuestionnaire.getQuestionnaireId());
			HwQuestion savedQustion = hwQuestionDao.save(question);
		}
		return new HwQuestionnaireResponse(List.of(savedQuestionnaire), questionList, RtnCode.SUCCESSFUL);
	}

	//­×§ï³o¸Ì
	@Override
	public HwQuestionnaireResponse search() {
		List<HwQuestionnaire> questionnaireList;
		questionnaireList = hwQuestionnaireDao.findAll();
		List<HwQuestion> questionList = hwQuestionDao.findAll();
		return new HwQuestionnaireResponse(questionnaireList, questionList, RtnCode.SUCCESSFUL);
	}

	@Override
	public HwQuestionnaireResponse searchParam(String questionName) {
		List<HwQuestionnaire> questionnaireList = hwQuestionnaireDao.findByQuestionNameContaining(questionName);

		if (questionnaireList.isEmpty()) {
			return new HwQuestionnaireResponse(null, RtnCode.QUESTIONNAIRE_ID_NOT_FOUND);
		} else {
			return new HwQuestionnaireResponse(questionnaireList, RtnCode.SUCCESSFUL);
		}
	}

	@Override
	public HwQuestionnaireResponse searchParamTime(
			@RequestParam(value = "question_name", required = false) String questionName, //
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam(value = "start_Time", required = false) LocalDate startTime, //
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam(value = "end_Time", required = false) LocalDate endTime) {

		questionName = StringUtils.hasText(questionName) ? questionName : "";
		startTime = startTime != null ? startTime : LocalDate.of(1971, 1, 1);
		endTime = endTime != null ? endTime : LocalDate.of(2099, 12, 31);

		List<HwQuestionnaire> questionnaireList;

		if (!questionName.isEmpty()) {
			questionnaireList = hwQuestionnaireDao
					.findByQuestionNameContainingAndStartTimeGreaterThanEqualAndEndTimeLessThanEqual(questionName,
							startTime, endTime);
		} else {
			questionnaireList = hwQuestionnaireDao.findByStartTimeGreaterThanEqualAndEndTimeLessThanEqual(startTime,
					endTime);
		}

		if (questionnaireList.isEmpty()) {
			return new HwQuestionnaireResponse(null, RtnCode.QUESTIONNAIRE_ID_NOT_FOUND);
		} else {
			return new HwQuestionnaireResponse(questionnaireList, RtnCode.SUCCESSFUL);
		}
	}

	@Override
	public HwQuestionnaireResponse getQuestionnaireInfoById(int questionnaireId) {

		return null;
	}

}
