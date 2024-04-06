package com.cafe.backend.menu.controller.form;

import com.cafe.backend.menu.service.dto.MenuModifyRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record MenuModifyForm(
        @NotBlank String name,
        @NotBlank String url,
        @NotNull Long sort
) {

    public MenuModifyRequest toDto() {
        return MenuModifyRequest.builder()
                .name(name)
                .url (url)
                .sort(sort)
                .build();
    }
}
