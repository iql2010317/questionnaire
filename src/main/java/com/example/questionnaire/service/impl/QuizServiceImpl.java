
package com.example.questionnaire.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.questionnaire.constants.RtnCode;
import com.example.questionnaire.entity.Question;
import com.example.questionnaire.entity.Questionnaire;
import com.example.questionnaire.repository.QuestionDao;
import com.example.questionnaire.repository.QuestionnaireDao;
import com.example.questionnaire.service.ifs.QuizService;
import com.example.questionnaire.vo.QuizReq;
import com.example.questionnaire.vo.QuizRes;
import com.example.questionnaire.vo.QuizVo;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuestionnaireDao qnDao;

	@Autowired
	private QuestionDao quDao;

	@Transactional
	@Override // 資料庫需要防範的東西 //寫資料庫的動作~
	public QuizRes create(QuizReq req) {

		List<QuizVo> quizVoList = new ArrayList<>();

		QuizRes checkResult = checkParam(req);
		if (checkResult != null) {
			return checkResult;
		}
		int qnid = qnDao.save(req.getQuestionnaire()).getId();
		List<Question> quList = req.getQuestionList();
		if (quList.isEmpty()) {
			return new QuizRes(quizVoList, RtnCode.SUCCESSFUL);
//		} else {
//			quizVoList.add(req);
		}
		for (Question qu : quList) {
			qu.setQnId(qnid);
		}
//		quDao.saveAll(quList);
		quDao.saveAll(req.getQuestionList());
		return new QuizRes(quizVoList, RtnCode.SUCCESSFUL);
	}

	private QuizRes checkParam(QuizReq req) {
		Questionnaire qn = req.getQuestionnaire();
		if (!StringUtils.hasText(qn.getTitle()) || !StringUtils.hasText(qn.getDescription())
				|| qn.getStartDate() == null || qn.getEndDate() == null || qn.getStartDate().isAfter(qn.getEndDate())) {
			return new QuizRes(RtnCode.QUESTIONNAIRE_PARAM_ERROR);
		}
		System.out.println("001");
		List<Question> quList = req.getQuestionList();
		for (Question qu : quList) {
			if (qu.getQuId() <= 0 || !StringUtils.hasText(qu.getqTitle()) || !StringUtils.hasText(qu.getOptionType())
					|| !StringUtils.hasText(qu.getOption())) {
				System.out.println("003");
				return new QuizRes(RtnCode.QUESTION_PARAM_ERROR);
			}
		}
		System.out.println("002");
		return null;
	}

	@Override
	public QuizRes update(QuizReq req) {
		QuizRes checkResult = checkParam(req);
		if (checkResult != null) {
			return checkResult;
		}
		checkResult = checkQnId(req);
		if (checkResult != null) {
			return checkResult;
		}
		Optional<Questionnaire> qnop = qnDao.findById(req.getQuestionnaire().getId());
		if (qnop.isEmpty()) {
			return new QuizRes(RtnCode.QUESTIONNAIRE_ID_NOT_FOUND);
		}
		Questionnaire qn = qnop.get();
		// 可以修改的條件
		// 1 is_published ==false,
		// 2 is_published ==true + 當前時間必須小於 start_date
		if (!qn.isPublished() || (qn.isPublished() && LocalDate.now().isBefore(qn.getStartDate()))) {
			qnDao.save(req.getQuestionnaire());
			quDao.saveAll(req.getQuestionList());
			return new QuizRes(RtnCode.SUCCESSFUL);
		}
		return new QuizRes(RtnCode.UPDATE_ERROR);
	}

	private QuizRes checkQnId(QuizReq req) {
		if (req.getQuestionnaire().getId() <= 0) {
			return new QuizRes(RtnCode.QUESTIONNAIRE_ID_PARAM_ERROR);
		}

		List<Question> quList = req.getQuestionList();
		for (Question qu : quList) {
			if (qu.getQuId() != req.getQuestionnaire().getId()) {
				return new QuizRes(RtnCode.QUESTIONNAIRE_ID_PARAM_ERROR);
			}
		}
		return null;
	}

	@Override
	public QuizRes deleteQuestionnaire(List<Integer> qnidList) {
		List<Questionnaire> qnList = qnDao.findByIdIn(qnidList);
		List<Integer> idList = new ArrayList<>();
		for (Questionnaire qn : qnList) {
			if (!qn.isPublished() || qn.isPublished() && LocalDate.now().isBefore(qn.getStartDate())) {
//				qnDao.deleteById(qn.getId());
				idList.add(qn.getId());
			}
		}
		if (!idList.isEmpty()) {
			// 刪問卷
			qnDao.deleteAllById(idList);
			// 刪問卷裡面的題目
			quDao.deleteAllByQnIdIn(idList);
		}
		return new QuizRes(RtnCode.SUCCESSFUL);

	}

	@Override
	public QuizRes deleteQuestion(int qnId, List<Integer> quidList) {
		Optional<Questionnaire> qnOp = qnDao.findById(qnId);
		if (qnOp.isEmpty()) {
			return new QuizRes(RtnCode.SUCCESSFUL);
		}
		Questionnaire qn = qnOp.get();
		if (!qn.isPublished() || qn.isPublished() && LocalDate.now().isBefore(qn.getStartDate())) {
			quDao.deleteAllByQnIdIn(quidList);
		}
		return new QuizRes(RtnCode.SUCCESSFUL);
	}

	@Override
	public QuizRes search(String title, LocalDate startDate, LocalDate endDate) {
		title = StringUtils.hasText(title) ? title : "";
		startDate = startDate != null ? startDate : LocalDate.of(1971, 1, 1);
		endDate = endDate != null ? endDate : LocalDate.of(2099, 12, 31);

		List<Questionnaire> qnList = qnDao
				.findByTitleContainingAndStartDateGreaterThanEqualAndEndDateLessThanEqual(title, startDate, endDate);

		List<Integer> qnIdList = new ArrayList<>();
		for (Questionnaire qu : qnList) {
			qnIdList.add(qu.getId());
		}
		List<Question> quList = quDao.findAllByQnIdIn(qnIdList);
		List<QuizVo> quizVoList = new ArrayList<>();
		for (Questionnaire qn : qnList) {
			QuizVo vo = new QuizVo();
			vo.setQuestionnaire(qn);
			List<Question> questionList = new ArrayList<>();
			for (Question qu : quList) {
				if (qu.getQnId() == qn.getId()) {
					questionList.add(qu);

				}
			}
			vo.setQuestionList(questionList);
			quizVoList.add(vo);
			System.out.println(vo);
		}
		return new QuizRes(quizVoList, RtnCode.SUCCESSFUL);
	}

}
