package com.cafe.backend.sample.service.dto;

import com.cafe.backend.sample.entity.Sample;
import lombok.Builder;

@Builder
public record SampleReadResponse(
        String title,
        String content
) {

    public static SampleReadResponse of(Sample sample) {
        return SampleReadResponse.builder()
                .title  (sample.getTitle())
                .content(sample.getContent())
                .build();
    }
}
