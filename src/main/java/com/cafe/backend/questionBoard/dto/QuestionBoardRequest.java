package com.cafe.backend.questionBoard.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class QuestionBoardRequest {
    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private String userId;

}
