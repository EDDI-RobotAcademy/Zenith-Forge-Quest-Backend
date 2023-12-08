package com.cafe.backend.questionBoard.service.request;

import com.cafe.backend.questionBoard.entity.QuestionBoard;
import com.cafe.backend.questionBoard.entity.QuestionBoardTag;
import com.cafe.backend.questionBoard.entity.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class QuestionBoardRegisterRequest {
    final private String title;
    final private String content;
    final private String userId;
    final private String category;
    final private List<String> tags;

    public QuestionBoard toQuestionBord() {
        return new QuestionBoard(title, content, userId, category);
    }

    public QuestionBoard toQuestionBordRequest() {
        return new QuestionBoard(title, content, userId, category);
    }

    public QuestionBoardTag toQuestionBoardexistingTag(Tag tag, QuestionBoard questionBoard) {
        return new QuestionBoardTag(tag, questionBoard);
    }

    public Tag toTag(String tagContent) {
        return new Tag(tagContent);
    }
}
