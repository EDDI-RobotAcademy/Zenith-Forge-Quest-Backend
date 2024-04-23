package com.cafe.backend.questionBoard.service;

import com.cafe.backend.questionBoard.entity.Topic;
import com.cafe.backend.questionBoard.service.request.QuestionBoardModifyRequest;
import com.cafe.backend.questionBoard.service.request.QuestionBoardSearchRequest;

import com.cafe.backend.questionBoard.entity.QuestionBoard;
import com.cafe.backend.questionBoard.service.request.QuestionBoardRegisterRequest;
import com.cafe.backend.questionBoard.service.request.QuestionBoardTopicRegisterRequest;

import java.util.List;

public interface QuestionBoardService {
    QuestionBoard createQuestion(QuestionBoardRegisterRequest createRequest);

    List<QuestionBoard> getQuestionByNonUser();

    List<QuestionBoard> getQuestionByUser(String userId);

    List<QuestionBoard> getQuestionSearchData(QuestionBoardSearchRequest searchRequest);

    Topic createQuestionTopic(QuestionBoardTopicRegisterRequest toQuestionBoardRegisterRequest);

    QuestionBoard modifyQuestionBoard(QuestionBoardModifyRequest toQuestionBoardModifyRequest);
}

/*
*
    List<QuestionBoard> getQuestionSearchData(QuestionBoardSearchRequest searchForm);

* */