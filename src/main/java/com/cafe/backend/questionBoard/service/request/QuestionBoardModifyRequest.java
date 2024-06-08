package com.cafe.backend.questionBoard.service.request;

import com.cafe.backend.questionBoard.entity.QuestionBoard;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class QuestionBoardModifyRequest {
    final private Long id;
    final private String title;
    final private String content;
    final private String userId;
    final private String topic;
    final private List<String> tags;

    public QuestionBoard toQuestionBord() {
        return new QuestionBoard(id, title, content, userId, topic);
    }
}
