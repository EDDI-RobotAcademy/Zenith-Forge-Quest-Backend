package com.cafe.backend.questionBoard.controller.form;

import com.cafe.backend.questionBoard.service.request.QuestionBoardRegisterRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class QuestionBoardRegisterRequestForm {
    @NotBlank
    final private String title;

    @NotBlank
    final private String content;

    @NotBlank
    final private String userId;

    @NotBlank
    final private String category;

    final private List<String> tags;

    public QuestionBoardRegisterRequest toQuestionBordRegisterRequest() {
        return new QuestionBoardRegisterRequest(title, content, userId, category, tags);
    }
}
