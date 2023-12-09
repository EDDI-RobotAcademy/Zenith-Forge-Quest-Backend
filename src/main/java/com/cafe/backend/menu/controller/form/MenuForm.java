package com.cafe.backend.menu.controller.form;

import com.cafe.backend.menu.service.dto.MenuRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public record MenuForm(
        @NotBlank String name,
        @NotBlank String url,
        @NotNull  Long sort,
        @Valid    List<MenuForm> children
) {
    public MenuRequest toDto() {
        return MenuRequest.builder()
                .name    (name)
                .url     (url)
                .sort    (sort)
                .children(children.stream()
                            .map(MenuForm::toDto)
                            .collect(Collectors.toList()))
                .build();
    }
}
