package com.cafe.backend.questionBoard.repository;

import com.cafe.backend.questionBoard.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    Optional<Topic> findByContent(String content);
}
