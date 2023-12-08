package com.cafe.backend.questionBoard.controller;

import com.cafe.backend.questionBoard.controller.form.QuestionTestForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.cafe.backend.questionBoard.dto.QuestionBoardRequest;
import com.cafe.backend.questionBoard.service.QuestionBoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/question-board")
@Tag(name = "Question Board", description = "Question Board API")
@RequiredArgsConstructor
public class QuestionBoardController {

    private final QuestionBoardService service;

    @GetMapping("/test")
    @Operation(summary = "Question Board Test", description = "질문 게시판 테스트입니다.")
    public String justTest () {
        return "Question Board Test";
    }

    @PostMapping()
    public ResponseEntity<Object> createCategory (@Valid @RequestBody QuestionBoardRequest createRequest) {
        service.createQuestion(createRequest);

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
}
