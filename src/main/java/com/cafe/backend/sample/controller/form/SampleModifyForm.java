package com.cafe.backend.sample.controller.form;

import com.cafe.backend.sample.service.dto.SampleModifyRequest;
import jakarta.validation.constraints.NotBlank;

public record SampleModifyForm(
        @NotBlank String title,
        @NotBlank String content
) {

    public SampleModifyRequest toDto() {
        return SampleModifyRequest.builder()
                .title  (title)
                .content(content)
                .build();
    }
}
