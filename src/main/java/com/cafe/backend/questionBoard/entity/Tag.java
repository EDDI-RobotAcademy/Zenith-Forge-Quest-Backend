package com.cafe.backend.questionBoard.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tag")
@Getter
@NoArgsConstructor
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String content;

    public Tag(String content) {
        TagContent tagContent = new TagContent(content);
        tagContent.validateContent();
        this.content = content;
    }
}
