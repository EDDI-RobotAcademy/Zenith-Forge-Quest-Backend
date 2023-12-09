package com.cafe.backend.menu.service.dto;

import com.cafe.backend.menu.entity.Menu;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Builder
public record MenuPageResponse(
        Long id,
        String name,
        LocalDateTime createdAt,
        Long createdBy
) {
    public static List<MenuPageResponse> of(List<Menu> content) {
        return content.stream()
                .map(MenuPageResponse::toResponse)
                .collect(Collectors.toList());
    }

    private static MenuPageResponse toResponse(Menu menu) {
        return MenuPageResponse.builder()
                .id       (menu.getId())
                .name     (menu.getName())
                .createdAt(menu.getCreatedAt())
                .createdBy(menu.getCreatedBy())
                .build();
    }
}
