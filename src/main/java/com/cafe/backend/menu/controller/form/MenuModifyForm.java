package com.cafe.backend.menu.controller.form;

import com.cafe.backend.menu.service.dto.MenuModifyRequest;
import lombok.Builder;

@Builder
public record MenuModifyForm() {

    public MenuModifyRequest toDto() {
        return MenuModifyRequest.builder()
                .build();
    }
}
