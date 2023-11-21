package com.example.questionnaire.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.questionnaire.service.ifs.QuizService;
import com.example.questionnaire.vo.QuizReq;
import com.example.questionnaire.vo.QuizRes;

@RestController
@CrossOrigin
public class QuizController {

	@Autowired
	private QuizService service;

	@PostMapping(value = "api/quiz/create")
	public QuizRes create(@RequestBody QuizReq req) {
		return service.create(req);
	}

//	@GetMapping(value = "api/quiz/search")
//	public QuizRes search(@RequestBody QuizSearchReq req) {
//		return service.search(req.getTitle(), req.getStartDate(), req.getEndDate());
//	}
	
	@GetMapping(value = "api/quiz/search")
	public QuizRes search(@RequestParam(value = "title", required = false) String title,
	                      @RequestParam(value = "startDate", required = false) LocalDate startDate,
	                      @RequestParam(value = "endDate", required = false) LocalDate endDate) {
	    return service.search(title, startDate, endDate);
	}


}
