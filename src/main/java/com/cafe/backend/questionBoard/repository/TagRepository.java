package com.cafe.backend.questionBoard.repository;

import com.cafe.backend.questionBoard.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findByContent(String tagContent);

    @Query("SELECT t FROM Tag t " +
            "JOIN QuestionBoardTag qbt ON t.id = qbt.tagId " +
            "WHERE qbt.questionId = :questionBoardId")
    List<Tag> findTagsByQuestionBoardId(@Param("questionBoardId") Long questionBoardId);
}
