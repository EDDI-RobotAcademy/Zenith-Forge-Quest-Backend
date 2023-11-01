package com.cafe.backend.questionBoard.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name="question_board")
@Getter
@NoArgsConstructor(access = PROTECTED)
public class QuestionBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 255)
    private String description;

    //보류 회원 id member table 연결 예정
    @Column(nullable = false, length = 50)
    private String userId;

    @Builder
    public QuestionBoard(Long id, String title, String description, String userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.userId = userId;
    }

}
