package com.cafe.backend.questionBoard.service;

import com.cafe.backend.questionBoard.entity.QuestionBoard;
import com.cafe.backend.questionBoard.repository.QuestionBoardRepository;
import com.cafe.backend.questionBoard.service.request.QuestionBoardRegisterRequest;
import com.cafe.backend.questionBoard.service.request.QuestionBoardSearchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<QuestionBoard> getQuestionByNonUser() {
        //TODO 비로그인 LIST 권한 추후 작업 예정
        return questionBoardRepository.findAllByOrderById();
    }

    @Override
    public List<QuestionBoard> getQuestionByUser(String userId) {
        return questionBoardRepository.findByUserId(userId);
    }

    @Override
    public List<QuestionBoard> getQuestionSearchData(QuestionBoardSearchRequest searchForm) {
        Specification<QuestionBoard> questionBoardSpecification = QuestionBoardSpecifications.searchQuestionBoard(searchForm);
        return questionBoardRepository.findAll(questionBoardSpecification);
    }
}