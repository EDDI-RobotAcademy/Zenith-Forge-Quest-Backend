package com.cafe.backend.questionBoard.controller.form;

import com.cafe.backend.questionBoard.service.request.QuestionBoardTopicRegisterRequest;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class QuestionBoardTopicRequestForm {
    final private String userId;
    final private  String topic;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public QuestionBoardTopicRequestForm(
            @JsonProperty("userId") String userId,
            @JsonProperty("topic") String topic) {
        this.userId = userId;
        this.topic = topic;
    }

    public QuestionBoardTopicRegisterRequest toQuestionBoardRegisterRequest() {
        return new QuestionBoardTopicRegisterRequest(userId, topic);
    }
}
