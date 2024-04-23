package com.cafe.backend.questionBoard.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="topic")
@Getter
@NoArgsConstructor
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String content;

    public Topic(String content) {
        TopicContent topicContent = new TopicContent(content);
        topicContent.validateContent();
        this.content = content;
    }
}
