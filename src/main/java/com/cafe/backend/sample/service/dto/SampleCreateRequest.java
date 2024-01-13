package com.cafe.backend.sample.service.dto;

import com.cafe.backend.sample.entity.Sample;
import lombok.Builder;

@Builder
public record SampleCreateRequest(
        String title,
        String content
) {

    public Sample toEntity() {
        return Sample.builder()
                .title  (title)
                .content(content)
                .build();
    }
}
