package com.cafe.backend.questionBoard.repository;

import com.cafe.backend.questionBoard.entity.QuestionBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionBoardRepository extends JpaRepository<QuestionBoard, Long> {
}
