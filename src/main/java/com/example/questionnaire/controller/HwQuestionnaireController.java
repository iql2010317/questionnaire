package com.example.questionnaire.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.questionnaire.service.ifs.HwQuestionnaireService;
import com.example.questionnaire.vo.HwQuestionnaireRequest;
import com.example.questionnaire.vo.HwQuestionnaireResponse;

@RestController
@CrossOrigin
public class HwQuestionnaireController {

	@Autowired
	private HwQuestionnaireService hwQuestionnaireService;

	@PostMapping(value = "api/HwQuestionnaire/create")
	public HwQuestionnaireResponse create(@RequestBody HwQuestionnaireRequest hwQuestionnaireRequest) {
		return hwQuestionnaireService.create(hwQuestionnaireRequest);
	}

	// 找全部
	@GetMapping(value = "api/HwQuestionnaire/search")
	public HwQuestionnaireResponse search() {
		return hwQuestionnaireService.search();
	}

	// 加上名稱
	@GetMapping(value = "api/HwQuestionnaire/searchParam")
	public HwQuestionnaireResponse searchParam(@RequestParam String questionName) {
		return hwQuestionnaireService.searchParam(questionName);
	}

	// 加上名稱+時間
	@GetMapping(value = "api/HwQuestionnaire/searchParamTime")
	public HwQuestionnaireResponse searchParamTime(
			@RequestParam(value = "question_name", required = false) String questionName,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam(value = "start_Time", required = false) LocalDate startTime,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam(value = "end_Time", required = false) LocalDate endTime) {
		// Your logic here using these parameters
		// Call your service method passing these parameters
		return hwQuestionnaireService.searchParamTime(questionName, startTime, endTime);
	}

}
