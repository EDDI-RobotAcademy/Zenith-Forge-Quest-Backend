package com.cafe.backend.questionBoard.repository;

import com.cafe.backend.questionBoard.entity.QuestionBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionBoardRepository extends JpaRepository<QuestionBoard, Long>, JpaSpecificationExecutor<QuestionBoard> {
    List<QuestionBoard> findAllByOrderById();

    List<QuestionBoard> findByUserId(String userId);
}
