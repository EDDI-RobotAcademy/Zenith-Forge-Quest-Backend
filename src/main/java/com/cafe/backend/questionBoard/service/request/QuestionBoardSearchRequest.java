package com.cafe.backend.questionBoard.service.request;

import com.cafe.backend.questionBoard.controller.form.QuestionBoardSearchType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public class QuestionBoardSearchRequest {
    final private String userId;
    final private QuestionBoardSearchType searchType;
    final private String searchWord;
    final private String tags;
    final private String category;
}