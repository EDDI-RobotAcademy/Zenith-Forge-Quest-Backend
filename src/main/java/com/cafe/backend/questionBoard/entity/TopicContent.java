package com.cafe.backend.questionBoard.entity;

import lombok.Getter;

@Getter
public class TopicContent {
    private String content;

    public TopicContent(String content) {
        this.content = content;
    }

    public void validateContent() {
        validateContentDataIsNull();
    }

    private void validateContentDataIsNull() {
        if(this.content.isEmpty()){
            throw new IllegalArgumentException("topic content가 없습니다.");
        }
    }
}
