package com.cafe.backend.sample.service.dto;

import lombok.Builder;

@Builder
public record SampleModifyRequest(
        String title,
        String content
) {
}
