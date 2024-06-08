package com.cafe.backend.questionBoard.repository;

import com.cafe.backend.questionBoard.entity.QuestionBoardTopic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionBoardTopicRepository extends JpaRepository<QuestionBoardTopic, Long> {
    Optional<QuestionBoardTopic> findByQuestionId(Long id);

    void deleteByQuestionId(Long id);
}
