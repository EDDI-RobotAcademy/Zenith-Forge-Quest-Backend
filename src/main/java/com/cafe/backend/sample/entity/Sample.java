package com.cafe.backend.sample.entity;

import com.cafe.backend.sample.service.dto.SampleModifyRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "sample")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Sample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Builder
    public Sample(String title, String content) {
        this.title   = title;
        this.content = content;
    }

    public void update(SampleModifyRequest sampleModifyForm) {
        this.title   = sampleModifyForm.title();
        this.content = sampleModifyForm.content();
    }
}
