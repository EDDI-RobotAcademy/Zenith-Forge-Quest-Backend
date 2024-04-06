package com.cafe.backend.sample.controller.form;

import com.cafe.backend.sample.service.dto.SampleCreateRequest;
import jakarta.validation.constraints.NotBlank;

public record SampleAddForm(
        @NotBlank String title,
        @NotBlank String content
) {

    public SampleCreateRequest toDto() {
        return SampleCreateRequest.builder()
                .title  (title)
                .content(content)
                .build();
    }
}
