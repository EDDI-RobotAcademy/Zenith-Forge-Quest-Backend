package com.cafe.backend.questionBoard.service;

import com.cafe.backend.questionBoard.dto.QuestionBoardRequest;
import com.cafe.backend.questionBoard.entity.QuestionBoard;
import com.cafe.backend.questionBoard.repository.QuestionBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class QuestionBoardServiceImpl implements QuestionBoardService{
    private final QuestionBoardRepository repository;
    @Override
    public void createQuestion(QuestionBoardRequest createRequest) {
        //TODO user id - memeber 작업 후 재작업 예정
        repository.save(QuestionBoard.builder()
                        .title(createRequest.getTitle())
                        .description(createRequest.getDescription())
                        .userId(createRequest.getUserId())
                .build());
    }
}
