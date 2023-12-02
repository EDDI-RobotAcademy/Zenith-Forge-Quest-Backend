package com.cafe.backend.questionBoard.controller.form;

public enum QuestionBoardSearchType {
    ALL("ALL"),
    TITLE("TITLE"),
    CONTENT("CONTENT");

    private final String searchType;

    QuestionBoardSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getSearchType() {
        return searchType;
    }

}