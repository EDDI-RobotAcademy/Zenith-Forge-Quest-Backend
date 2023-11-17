package com.cafe.backend.questionBoard.controller;

import com.cafe.backend.questionBoard.controller.form.QuestionBoardRegisterRequestForm;
import com.cafe.backend.questionBoard.entity.QuestionBoard;
import com.cafe.backend.questionBoard.service.QuestionBoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/question-board")
@RequiredArgsConstructor
public class QuestionBoardController {

    private final QuestionBoardService service;

    @GetMapping("/test")
    public String justTest () {
        return "Question Board Test";
    }

    @PostMapping(value = "/register")
    public ResponseEntity<Object> registerQuestionBoard (@Valid @RequestBody QuestionBoardRegisterRequestForm createRequest) {
        service.createQuestion(createRequest.toQuestionBordRegisterRequest());

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping(value = "/list/nonUser")
    public ResponseEntity<Object> getQuestionNonUser () {
        List<QuestionBoard> questionBoard = service.getQuestionByNonUser();
        return new ResponseEntity<>(questionBoard, HttpStatus.OK);
    }

    @GetMapping(value = "/list/user")
    public ResponseEntity<Object> getQuestionByUser (@RequestParam String userId) {
        List<QuestionBoard> questionBoard = service.getQuestionByUser(userId);
        return new ResponseEntity<Object>(questionBoard, null, HttpStatus.OK);
    }

}
