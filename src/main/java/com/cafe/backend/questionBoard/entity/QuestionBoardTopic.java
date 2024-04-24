package com.cafe.backend.questionBoard.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="question_board_topic")
@Getter
@NoArgsConstructor
public class QuestionBoardTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "topic_id")
    private Long topicId;

    @Column(name = "question_id")
    private Long questionId;

    public QuestionBoardTopic (Topic topic, QuestionBoard questionBoard){
        this.questionId = questionBoard.getId();
        this.topicId = topic.getId();
    }
}
