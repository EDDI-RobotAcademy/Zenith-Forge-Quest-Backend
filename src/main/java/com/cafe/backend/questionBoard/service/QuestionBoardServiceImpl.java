package com.cafe.backend.questionBoard.service;

import com.cafe.backend.questionBoard.entity.*;
import com.cafe.backend.questionBoard.repository.*;
//import com.cafe.backend.questionBoard.service.request.QuestionBoardModifyRequest;
import com.cafe.backend.questionBoard.service.request.QuestionBoardRegisterRequest;
import com.cafe.backend.questionBoard.service.request.QuestionBoardSearchRequest;
import com.cafe.backend.questionBoard.service.request.QuestionBoardTopicRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class QuestionBoardServiceImpl implements QuestionBoardService{
    private final QuestionBoardRepository questionBoardRepository;
    private final TagRepository tagRepository;
    private final QuestionBoardTagRepository questionBoardTagRepository;
    private final TopicRepository topicRepository;

    @Override
    public QuestionBoard createQuestion(QuestionBoardRegisterRequest createRequest) {
        //TODO user id - memeber 작업 후 재작업 예정
        //TODO topic  작업 후 추가 보수 예정
        QuestionBoard questionBoard = questionBoardRepository.save(createRequest.toQuestionBord());

        if(validateQuestionBoardTopic(createRequest)){
            throw new IllegalArgumentException("관련된 topic이 없습니다.");
        }

        createQuestionBoardTag(createRequest, questionBoard);

        return questionBoard ;
    }

    private boolean validateQuestionBoardTopic(QuestionBoardRegisterRequest createRequest) {
        Optional<Topic> hasTopicContent = topicRepository.findByContent(createRequest.getContent());
        if(hasTopicContent.isPresent()){
            return true;
        }else return false;
    }

    private void createQuestionBoardTag(QuestionBoardRegisterRequest createRequest, QuestionBoard questionBoard) {
        for(String tagContent : createRequest.getTags()) {
            Tag existingTag = tagRepository.findByContent(tagContent);
            if(existingTag != null) {
                questionBoardTagRepository.save(createRequest.toQuestionBoardexistingTag(existingTag, questionBoard));
            }else {
                Tag newTag  = tagRepository.save(createRequest.toTag(tagContent));
                questionBoardTagRepository.save(createRequest.toQuestionBoardexistingTag(newTag,  questionBoard));
            }
        }
    }


    @Override
    @Transactional(readOnly = true)
    public List<QuestionBoard> getQuestionByNonUser() {
        //TODO 비로그인 LIST 권한 추후 작업 예정
        return questionBoardRepository.findAllByOrderById();
    }

    @Override
    public List<QuestionBoard> getQuestionByUser(String userId) {
        return questionBoardRepository.findByUserId(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<QuestionBoard> getQuestionSearchData(QuestionBoardSearchRequest searchForm) {
        Specification<QuestionBoard> questionBoardSpecification = QuestionBoardSpecifications.searchQuestionBoard(searchForm);
        return questionBoardRepository.findAll(questionBoardSpecification);
    }

    @Override
    public Topic createQuestionTopic(QuestionBoardTopicRegisterRequest createRequest) {
        if(createRequest.getUserId().equals("admin")){
            return topicRepository.save(createRequest.toTopic(createRequest.getTopic()));
        }else {
            throw new IllegalArgumentException("no admin user");
        }

    }

//    @Override
//    public QuestionBoard modifyQuestionBoard(QuestionBoardModifyRequest questionBoardModifyRequest) {
//        QuestionBoard questionBoard = questionBoardRepository.save(questionBoardModifyRequest.toQuestionBord());
//
//        return questionBoard;
//    }


}