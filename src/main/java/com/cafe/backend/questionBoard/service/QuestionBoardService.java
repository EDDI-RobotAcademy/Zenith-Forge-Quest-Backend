package com.cafe.backend.questionBoard.service;

import com.cafe.backend.questionBoard.dto.QuestionBoardRequest;
import jakarta.validation.Valid;

public interface QuestionBoardService {
    void createQuestion(QuestionBoardRequest createRequest);
}
