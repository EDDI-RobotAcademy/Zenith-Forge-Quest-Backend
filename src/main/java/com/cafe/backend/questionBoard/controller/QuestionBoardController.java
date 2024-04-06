package com.cafe.backend.questionBoard.controller;
import com.cafe.backend.questionBoard.controller.form.QuestionBoardSearchRequestForm;

import com.cafe.backend.questionBoard.controller.form.QuestionBoardRegisterRequestForm;
import com.cafe.backend.questionBoard.controller.form.QuestionBoardTopicRequestForm;
import com.cafe.backend.questionBoard.entity.QuestionBoard;
import com.cafe.backend.questionBoard.entity.Topic;
import com.cafe.backend.questionBoard.service.QuestionBoardService;
import com.cafe.backend.questionBoard.service.request.QuestionBoardTopicRegisterRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    private final ObjectMapper objectMapper;

    @PostMapping(value = "/register/topic")
    public ResponseEntity<Object> registerTopicQuestionBoard (@RequestBody QuestionBoardTopicRequestForm createTopic) {
        Topic topic = service.createQuestionTopic(createTopic.toQuestionBoardRegisterRequest());

        return new ResponseEntity<>(topic, HttpStatus.CREATED);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<Object> registerQuestionBoard (@RequestBody QuestionBoardRegisterRequestForm createRequest) {
        QuestionBoard questionBoard = service.createQuestion(createRequest.toQuestionBoardRegisterRequest());

        return new ResponseEntity<>(questionBoard, HttpStatus.CREATED);
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

    @GetMapping(value = "/list/search")
    public ResponseEntity<Object> getQuestionSearchData (@RequestParam Map<String,Object> params) {

        QuestionBoardSearchRequestForm searchForm = objectMapper.convertValue(params, QuestionBoardSearchRequestForm.class);
        List<QuestionBoard> questionBoard = service.getQuestionSearchData(searchForm.toQuestionBoardSearchRequest());

        return new ResponseEntity<Object>(questionBoard,null, HttpStatus.OK);
    }
}