package com.cafe.backend.questionBoard.controller;

import com.cafe.backend.questionBoard.controller.form.QuestionTestForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/question-board")
@Tag(name = "Question Board", description = "Question Board API")
public class QuestionBoardController {

    @GetMapping("/test")
    @Operation(summary = "Question Board Test", description = "질문 게시판 테스트입니다.")
    public String justTest () {
        return "Question Board Test";
    }
}
