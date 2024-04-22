package com.cafe.backend.questionBoard.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name="question_board")
@Getter
@NoArgsConstructor
public class QuestionBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 255)
    private String content;

    //TODO 보류 회원 id member table 연결 예정
    @Column(nullable = false, length = 50)
    private String userId;

    @Transient
    private List<Tag> tags;

    @Transient
    private Topic topic;

    public QuestionBoard(String title, String content, String userId, String topic) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
//        this.topic = topic;
    }
    public QuestionBoard(Long id, String title, String content, String userId, String topic) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
//        this.topic = topic;
    }

    public void setTagsFromQuestionBoardId(List<Tag> questionTags){
        this.tags= questionTags;
    }

    public void setTopicFromQuestionBoardId(Topic topic){
        this.topic= topic;
    }
}
