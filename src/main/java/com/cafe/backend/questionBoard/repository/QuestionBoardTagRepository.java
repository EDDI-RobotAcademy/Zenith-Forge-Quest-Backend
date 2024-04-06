package com.cafe.backend.questionBoard.repository;

import com.cafe.backend.questionBoard.entity.QuestionBoardTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QuestionBoardTagRepository extends JpaRepository<QuestionBoardTag, Long> {
}
