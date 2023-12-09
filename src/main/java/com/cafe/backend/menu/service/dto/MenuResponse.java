package com.cafe.backend.menu.service.dto;

import com.cafe.backend.menu.entity.Menu;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;

@Builder
public record MenuResponse(
        Long   id,
        String name,
        String url,
        Long   sort,
        List<MenuResponse> children
) {

    public static MenuResponse of(Menu menu) {
        return MenuResponse.builder()
                .id(menu.getId())
                .name(menu.getName())
                .url(menu.getUrl())
                .sort(menu.getSort())
                .children(menu.getChildren().stream()
                        .map(MenuResponse::of)
                        .collect(Collectors.toList()))
                .build();
    }
}
