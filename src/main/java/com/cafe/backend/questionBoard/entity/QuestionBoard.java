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
    private String description;

    //보류 회원 id member table 연결 예정
    @Column(nullable = false, length = 50)
    private String userId;

    //보류 카테고리 table 연결 예정
    @Column(nullable = false, length = 100)
    private String category;

    //보류 태그 table 연결 예정
    @Column(nullable = false, length = 100)
    private List<String> tags;

    public QuestionBoard(String title, String description, String userId, String category, List<String> tags) {
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.category = category;
        this.tags = tags;
    }
}
