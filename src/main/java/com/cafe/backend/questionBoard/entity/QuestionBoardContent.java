package com.cafe.backend.questionBoard.entity;

import lombok.Getter;

@Getter
public class QuestionBoardContent {
    final private String content;


    public QuestionBoardContent(String content)  {
        this.content = content;
        validateContent();
    }

    public void validateContent() {
        if (this.content.contains("나쁜말")) {
            throw new RuntimeException("나쁜말은 안돼요~! 지지!!");
        }
    }
}
