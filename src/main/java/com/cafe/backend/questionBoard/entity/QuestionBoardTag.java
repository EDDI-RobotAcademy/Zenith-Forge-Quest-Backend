package com.cafe.backend.questionBoard.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="question_board_tag")
@Getter
@NoArgsConstructor
public class QuestionBoardTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tag_id")
    private Long tagId;

    @Column(name = "question_id")
    private Long questionId;

    public QuestionBoardTag (Tag tag, QuestionBoard questionBoard){
        this.questionId = questionBoard.getId();
        this.tagId = tag.getId();
    }
}
