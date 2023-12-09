package com.cafe.backend.menu.service.dto;

import com.cafe.backend.menu.entity.Menu;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;

@Builder
public record MenuReadResponse(
        Long   id,
        String name,
        String url,
        Long   sort,
        MenuReadResponse parent,
        List<MenuReadResponse> children
) {

    public static MenuReadResponse of(Menu menu) {
        return MenuReadResponse.builder()
                .id      (menu.getId())
                .name    (menu.getName())
                .url     (menu.getUrl())
                .sort    (menu.getSort())
                .parent  (menu.getParent() == null ? null : MenuReadResponse.setParent(menu.getParent()))
                .children(menu.getChildren().isEmpty() ? null : menu.getChildren().stream()
                            .map(MenuReadResponse::of)
                            .collect(Collectors.toList()))
                .build();
    }

    private static MenuReadResponse setParent(Menu parent) {
        return MenuReadResponse.builder()
                .id(parent.getId())
                .build();
    }
}
