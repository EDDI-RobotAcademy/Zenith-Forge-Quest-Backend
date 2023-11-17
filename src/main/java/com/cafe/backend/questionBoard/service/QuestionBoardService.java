package com.cafe.backend.questionBoard.service;

import com.cafe.backend.questionBoard.controller.form.QuestionBoardSearchRequestForm;
import com.cafe.backend.questionBoard.service.request.QuestionBoardSearchRequest;

import com.cafe.backend.questionBoard.entity.QuestionBoard;
import com.cafe.backend.questionBoard.service.request.QuestionBoardRegisterRequest;
import java.util.List;

public interface QuestionBoardService {
    QuestionBoard createQuestion(QuestionBoardRegisterRequest createRequest);

    List<QuestionBoard> getQuestionByNonUser();

    List<QuestionBoard> getQuestionByUser(String userId);
}

/*
*
    List<QuestionBoard> getQuestionSearchData(QuestionBoardSearchRequest searchForm);

* */