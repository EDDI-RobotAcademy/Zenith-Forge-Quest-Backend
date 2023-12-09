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
        List<MenuReadResponse> children
) {

    public static MenuReadResponse of(Menu menu) {
        return MenuReadResponse.builder()
                .id(menu.getId())
                .name(menu.getName())
                .url(menu.getUrl())
                .sort(menu.getSort())
                .children(menu.getChildren().stream()
                        .map(MenuReadResponse::of)
                        .collect(Collectors.toList()))
                .build();
    }
}
