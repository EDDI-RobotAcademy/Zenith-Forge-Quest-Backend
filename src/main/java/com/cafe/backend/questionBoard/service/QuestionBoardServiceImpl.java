package com.cafe.backend.questionBoard.service;

import com.cafe.backend.questionBoard.entity.QuestionBoard;
import com.cafe.backend.questionBoard.repository.QuestionBoardRepository;
import com.cafe.backend.questionBoard.service.request.QuestionBoardRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class QuestionBoardServiceImpl implements QuestionBoardService{
    private final QuestionBoardRepository questionBoardRepository;
    @Override
    public QuestionBoard createQuestion(QuestionBoardRegisterRequest createRequest) {
        //TODO user id - memeber 작업 후 재작업 예정
        //TODO category / tag 작업 후 추가 보수 예정
        return  questionBoardRepository.save(createRequest.toQuestionBordRequest());
    }
}
