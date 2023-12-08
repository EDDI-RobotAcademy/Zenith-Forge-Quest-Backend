package com.cafe.backend.questionBoard.repository;

import com.cafe.backend.questionBoard.entity.QuestionBoardTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionBoardTagRepository extends JpaRepository<QuestionBoardTag, Long> {
}
