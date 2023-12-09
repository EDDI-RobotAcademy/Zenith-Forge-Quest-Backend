package com.cafe.backend.menu.controller.form;

import com.cafe.backend.menu.service.dto.MenuAddRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;

@Builder
public record MenuAddForm(
        @NotBlank String name,
                  String url,
        @NotNull  Long sort,
        @Valid    List<MenuForm> children
) {

    public MenuAddRequest toDto() {
        return MenuAddRequest.builder()
                .name    (name)
                .url     (url)
                .sort    (sort)
                .children(children.stream()
                            .map(MenuForm::toDto)
                            .collect(Collectors.toList()))
                .build();
    }
}
