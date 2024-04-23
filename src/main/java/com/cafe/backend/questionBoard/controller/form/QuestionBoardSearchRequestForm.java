package com.cafe.backend.questionBoard.controller.form;

import com.cafe.backend.questionBoard.service.request.QuestionBoardSearchRequest;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class QuestionBoardSearchRequestForm {
    final private String userId;
    @JsonProperty("searchType")
    final private QuestionBoardSearchType searchType;
    final private String searchWord;
    final private String tags;
    final private String topic;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public QuestionBoardSearchRequestForm(
            @JsonProperty("searchType") QuestionBoardSearchType searchType,
            @JsonProperty("searchWord") String searchWord,
            @JsonProperty("userId") String userId,
            @JsonProperty("tags") String tags,
            @JsonProperty("topic") String topic) {
        this.searchType = searchType;
        this.searchWord = searchWord;
        this.userId = userId;
        this.topic = topic;
        this.tags = tags;
    }

    public QuestionBoardSearchRequest toQuestionBoardSearchRequest() {
        return new QuestionBoardSearchRequest(userId, searchType, searchWord, tags, topic);
    }
}
