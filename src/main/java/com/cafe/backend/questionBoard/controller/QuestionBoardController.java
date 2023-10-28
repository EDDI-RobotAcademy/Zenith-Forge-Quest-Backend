package com.cafe.backend.questionBoard.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/question-board")
public class QuestionBoardController {

    @GetMapping("/test")
    public String justTest () {
        return "Question Board Test";
    }
}
