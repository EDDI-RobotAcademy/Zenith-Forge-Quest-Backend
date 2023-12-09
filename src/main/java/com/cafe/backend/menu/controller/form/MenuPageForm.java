package com.cafe.backend.menu.controller.form;

import com.cafe.backend.menu.service.dto.MenuPageRequest;

public record MenuPageForm() {

    public MenuPageRequest toDto() {
        return MenuPageRequest.builder()
                .build();
    }
}
