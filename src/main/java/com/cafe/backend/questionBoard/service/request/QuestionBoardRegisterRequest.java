package com.cafe.backend.questionBoard.service.request;

import com.cafe.backend.questionBoard.entity.QuestionBoard;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class QuestionBoardRegisterRequest {
    final private String title;
    final private String description;
    final private String userId;
    final private String category;
    final private List<String> tags;

    public QuestionBoard toQuestionBordRequest() {
        return new QuestionBoard(title, description, userId, category, tags);
    }
}
