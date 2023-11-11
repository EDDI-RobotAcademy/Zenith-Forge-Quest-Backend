package com.cafe.backend.questionBoard.service;

import com.cafe.backend.questionBoard.entity.QuestionBoard;
import com.cafe.backend.questionBoard.service.request.QuestionBoardRegisterRequest;

public interface QuestionBoardService {
    QuestionBoard createQuestion(QuestionBoardRegisterRequest createRequest);
}
