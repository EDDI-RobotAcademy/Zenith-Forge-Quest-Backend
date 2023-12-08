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

    //TODO 보류 카테고리 table 연결 예정 ->추후 category -> menu로 변경 예정
    @Column(nullable = false, length = 100)
    private String category;

    @Transient
    private List<Tag> tags;

    public QuestionBoard(String title, String content, String userId, String category) {
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.category = category;
    }

    public void setTagsFromQuestionBoardId(List<Tag> questionTags){
        this.tags= questionTags;
    }
}
