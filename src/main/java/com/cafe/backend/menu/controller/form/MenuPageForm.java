package com.cafe.backend.menu.controller.form;

import com.cafe.backend.menu.service.dto.MenuPageRequest;

public record MenuPageForm(
        String name
) {

    public MenuPageRequest toDto() {
        return MenuPageRequest.builder()
                .name(name)
                .build();
    }
}
