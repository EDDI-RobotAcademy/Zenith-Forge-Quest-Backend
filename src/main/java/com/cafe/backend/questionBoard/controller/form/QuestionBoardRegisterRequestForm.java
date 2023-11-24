package com.cafe.backend.questionBoard.controller.form;

import com.cafe.backend.questionBoard.entity.QuestionBoardContent;
import com.cafe.backend.questionBoard.service.request.QuestionBoardRegisterRequest;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class QuestionBoardRegisterRequestForm {
    private final String title;
    private final String content;
    private final String userId;
    private final String category;
    private final String tags;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public QuestionBoardRegisterRequestForm(
            @JsonProperty("title") String title,
            @JsonProperty("content") String content,
            @JsonProperty("userId") String userId,
            @JsonProperty("category") String category,
            @JsonProperty("tags") String tags) {
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.category = category;
        this.tags = tags;
    }

    public QuestionBoardRegisterRequest toQuestionBoardRegisterRequest() {
        QuestionBoardContent questionBoardContent = new QuestionBoardContent(content);
        questionBoardContent.validateContent();

        return new QuestionBoardRegisterRequest(title, content, userId, category, tags);
    }
}