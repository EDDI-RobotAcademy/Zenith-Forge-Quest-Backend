package com.cafe.backend.questionBoard.service.request;

import com.cafe.backend.questionBoard.entity.Topic;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class QuestionBoardTopicRegisterRequest {
    final private String userId;
    final private String topic;


    public Topic toTopic(String topic) {
        return new Topic(topic);
    }
}
