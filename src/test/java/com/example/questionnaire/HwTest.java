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
		hwQuestionnaire.setQuestionName("����8");
		hwQuestionnaire.setDescription("�ݨ�15���y�z");
		hwQuestionnaire.setStartTime(startDate);
		hwQuestionnaire.setEndTime(endDate);
		hwQuestionnaire.setPublished(false);

		List<HwQuestion> questionList = new ArrayList<>();

		HwQuestion Q1 = new HwQuestion();
		Q1.setQuestionType("radio");
		Q1.setNecessary(false);
		Q1.setQuestionText("Q1.���ѦY����(���)");
		Q1.setOptionText("����;�@��;����");

		HwQuestion Q2 = new HwQuestion();
		Q2.setQuestionType("checkbox");
		Q2.setQuestionText("Q2.���ѥh����(�ƿ�)");
		Q2.setOptionText("�x��;����;�̪F");

		HwQuestion Q3 = new HwQuestion();
		Q3.setQuestionType("text");
		Q3.setQuestionText("Q3.���ӷQ�F��(²��)");

		questionList.addAll(Arrays.asList(Q1, Q2, Q3));

		HwQuestionnaireRequest req = new HwQuestionnaireRequest(hwQuestionnaire, questionList);
		HwQuestionnaireResponse res = hwQuestionnaireService.create(req);

		// ���B�����٥]�A�@���_���A�H���Ҧ^�������e�P�w���O�_�۲�
		// res �]�t�w�g�O�s��ƾڮw���ݨ��M���D�A�A�i�H�ھڻݨD�K�[�_��
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
		String questionName = "����"; //
		HwQuestionnaireResponse response = hwQuestionnaireService.searchParam(questionName);

		List<HwQuestionnaire> questionnaireList = response.getHwQuestionnaireList();
		for (HwQuestionnaire questionnaire : questionnaireList) {
			System.out.println("Questionnaire ID: " + questionnaire.getQuestionnaireId());
			System.out.println("Questionnaire Name: " + questionnaire.getQuestionName());
			System.out.println("Description: " + questionnaire.getDescription());
			System.out.println("---------------------");
		}
	}

	// ���զW�٥[�ɶ� OK
	@Test
	public void testSearchParamTime() {
		LocalDate startDate = LocalDate.parse("2023-11-24");
		LocalDate endDate = LocalDate.parse("2023-11-25");
		//�W�r�i�H���ť� �Ŧr�� 
		HwQuestionnaireResponse response = hwQuestionnaireService.searchParamTime("�W��",startDate , endDate);
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
