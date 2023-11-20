package com.example.questionnaire;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.questionnaire.entity.Question;
import com.example.questionnaire.entity.Questionnaire;
import com.example.questionnaire.service.ifs.QuizService;
import com.example.questionnaire.vo.QuizReq;
import com.example.questionnaire.vo.QuizRes;

@SpringBootTest
class QuestionnaireApplicationTests {

	@Autowired
	private QuizService quizService;

	@Test
	public void test() {
		LocalDate startDate = LocalDate.parse("2022-11-17");
		LocalDate endDate = LocalDate.parse("2022-11-20");
		Questionnaire questionnaire1 = new Questionnaire("happy1118", "happy1118", true, startDate, endDate);
		List<Question> questionList1 = new ArrayList<>();
		Question Q1 = new Question(1, "con001", "radio", true, "AAA;BBB;CCC");
		Question Q2 = new Question(2, "con002", "checkbox", true, "10;20;30;40");
		Question Q3 = new Question(3, "con003", "text", true, "123213");
		questionList1.addAll(Arrays.asList(Q1, Q2, Q3));

		QuizReq req = new QuizReq(questionnaire1, questionList1);
		QuizRes res = quizService.create(req);

	}
	
	@Test
	//搜尋名稱 開始時間 結束時間 可以為空
	public void searchTest() {
	    System.out.println("================================");
	    quizService.search("happy", null, null);
	    System.out.println("================================");
	}
	
	
	

}
