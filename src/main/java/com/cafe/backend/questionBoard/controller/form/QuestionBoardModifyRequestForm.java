package com.cafe.backend.questionBoard.controller.form;

import com.cafe.backend.questionBoard.entity.QuestionBoardContent;
import com.cafe.backend.questionBoard.service.request.QuestionBoardModifyRequest;
import com.cafe.backend.questionBoard.service.request.QuestionBoardRegisterRequest;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class QuestionBoardModifyRequestForm {
    private final Long id;
    private final String title;
    private final String content;
    private final String userId;
    private final String topic;
    private final List<String> tags;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public QuestionBoardModifyRequestForm(
            @JsonProperty("id") Long id,
            @JsonProperty("title") String title,
            @JsonProperty("content") String content,
            @JsonProperty("userId") String userId,
            @JsonProperty("topic") String topic,
            @JsonProperty("tags") List<String> tags) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.topic = topic;
        this.tags = tags;
    }

    public QuestionBoardModifyRequest toQuestionBoardModifyRequest(Long boardId) {
        QuestionBoardContent questionBoardContent = new QuestionBoardContent(content);
        questionBoardContent.validateContent();

        return new QuestionBoardModifyRequest(boardId, title, content, userId, topic, tags);
    }
}
