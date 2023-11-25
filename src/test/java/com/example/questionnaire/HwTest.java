package com.example.questionnaire;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.questionnaire.entity.HwQuestion;
import com.example.questionnaire.entity.HwQuestionnaire;
import com.example.questionnaire.service.ifs.HwQuestionnaireService;
import com.example.questionnaire.vo.HwQuestionnaireRequest;
import com.example.questionnaire.vo.HwQuestionnaireResponse;

@SpringBootTest
public class HwTest {

	@Autowired
	private HwQuestionnaireService hwQuestionnaireService;

	@Test
	public void testCreateQuestionnaire() {
		LocalDate startDate = LocalDate.parse("2022-11-19");
		LocalDate endDate = LocalDate.parse("2022-11-20");

		HwQuestionnaire hwQuestionnaire = new HwQuestionnaire();
		hwQuestionnaire.setQuestionName("測試8");
		hwQuestionnaire.setDescription("問卷15的描述");
		hwQuestionnaire.setStartTime(startDate);
		hwQuestionnaire.setEndTime(endDate);
		hwQuestionnaire.setPublished(false);

		List<HwQuestion> questionList = new ArrayList<>();

		HwQuestion Q1 = new HwQuestion();
		Q1.setQuestionType("radio");
		Q1.setNecessary(false);
		Q1.setQuestionText("Q1.今天吃什麼(單選)");
		Q1.setOptionText("火鍋;咖哩;牛排");

		HwQuestion Q2 = new HwQuestion();
		Q2.setQuestionType("checkbox");
		Q2.setQuestionText("Q2.明天去哪裡(複選)");
		Q2.setOptionText("台中;高雄;屏東");

		HwQuestion Q3 = new HwQuestion();
		Q3.setQuestionType("text");
		Q3.setQuestionText("Q3.未來想幹嘛(簡答)");

		questionList.addAll(Arrays.asList(Q1, Q2, Q3));

		HwQuestionnaireRequest req = new HwQuestionnaireRequest(hwQuestionnaire, questionList);
		HwQuestionnaireResponse res = hwQuestionnaireService.create(req);

		// 此處應該還包括一些斷言，以驗證回應的內容與預期是否相符
		// res 包含已經保存到數據庫的問卷和問題，你可以根據需求添加斷言
	}

	@Test
	public void testSearch() {
		HwQuestionnaireResponse response = hwQuestionnaireService.search();
		List<HwQuestionnaire> questionnaireList = response.getHwQuestionnaireList();

		if (questionnaireList != null && !questionnaireList.isEmpty()) {
			for (HwQuestionnaire questionnaire : questionnaireList) {
				System.out.println("Questionnaire ID: " + questionnaire.getQuestionnaireId());
				System.out.println("Questionnaire Name: " + questionnaire.getQuestionName());
				// Print other details as needed
			}
		} else {
			System.out.println("No questionnaires found.");
		}
	}

	@Test
	public void testSearchParam() {
		String questionName = "測試"; //
		HwQuestionnaireResponse response = hwQuestionnaireService.searchParam(questionName);

		List<HwQuestionnaire> questionnaireList = response.getHwQuestionnaireList();
		for (HwQuestionnaire questionnaire : questionnaireList) {
			System.out.println("Questionnaire ID: " + questionnaire.getQuestionnaireId());
			System.out.println("Questionnaire Name: " + questionnaire.getQuestionName());
			System.out.println("Description: " + questionnaire.getDescription());
			System.out.println("---------------------");
		}
	}

	// 測試名稱加時間 OK
	@Test
	public void testSearchParamTime() {
		LocalDate startDate = LocalDate.parse("2023-11-24");
		LocalDate endDate = LocalDate.parse("2023-11-25");
		//名字可以為空白 空字串 
		HwQuestionnaireResponse response = hwQuestionnaireService.searchParamTime("上課",startDate , endDate);
		List<HwQuestionnaire> questionnaireList = response.getHwQuestionnaireList();
		for (HwQuestionnaire questionnaire : questionnaireList) {
			System.out.println("Questionnaire ID: " + questionnaire.getQuestionnaireId());
			System.out.println("Questionnaire Name: " + questionnaire.getQuestionName());
			System.out.println("startTime: " + questionnaire.getStartTime());
			System.out.println("endTime: " + questionnaire.getEndTime());
			System.out.println("---------------------");
		}

	}

}
