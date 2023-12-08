package com.cafe.backend.questionBoard.service;

import com.cafe.backend.questionBoard.entity.QuestionBoard;
import com.cafe.backend.questionBoard.entity.QuestionBoardTag;
import com.cafe.backend.questionBoard.entity.Tag;
import com.cafe.backend.questionBoard.repository.QuestionBoardRepository;
import com.cafe.backend.questionBoard.repository.QuestionBoardTagRepository;
import com.cafe.backend.questionBoard.repository.TagRepository;
import com.cafe.backend.questionBoard.service.request.QuestionBoardRegisterRequest;
import com.cafe.backend.questionBoard.service.request.QuestionBoardSearchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class QuestionBoardServiceImpl implements QuestionBoardService{
    private final QuestionBoardRepository questionBoardRepository;
    private final TagRepository tagRepository;
    private final QuestionBoardTagRepository questionBoardTagRepository;

    @Override
    public QuestionBoard createQuestion(QuestionBoardRegisterRequest createRequest) {
        //TODO user id - memeber 작업 후 재작업 예정
        //TODO topic  작업 후 추가 보수 예정
        QuestionBoard questionBoard = questionBoardRepository.save(createRequest.toQuestionBord());
        createQuestionBoardTag(createRequest, questionBoard);
        questionBoard.setTagsFromQuestionBoardId(findTagsFromQuestionBoardId(questionBoard.getId()));
        return questionBoard ;
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

    private List<Tag> findTagsFromQuestionBoardId(Long questionBoardId) {
        return tagRepository.findTagsByQuestionBoardId(questionBoardId);
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
    
    
}