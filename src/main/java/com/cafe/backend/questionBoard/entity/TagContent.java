package com.cafe.backend.questionBoard.entity;

import lombok.Getter;

@Getter
public class TagContent {
    private String content;

    public TagContent(String content) {
        this.content = content;
    }

    public void validateContent() {
        validateContentDataIsNull();
        validateLowerCase();
    }

    private void validateContentDataIsNull() {
        if(this.content.isEmpty()){
            throw new IllegalArgumentException("tag content가 없습니다.");
        }
    }

    //추후 변경
    private void validateLowerCase() {
        if (!this.content.equals(this.content.toLowerCase())) {
            this.content = this.content.toLowerCase();
        }
    }
}
