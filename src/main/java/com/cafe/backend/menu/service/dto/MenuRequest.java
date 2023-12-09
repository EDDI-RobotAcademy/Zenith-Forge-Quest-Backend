package com.cafe.backend.menu.service.dto;

import com.cafe.backend.menu.entity.Menu;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;

@Builder
public record MenuRequest(
        String name,
        String url,
        Long sort,
        MenuRequest parent,
        List<MenuRequest> children
) {
    public Menu toEntity() {
        return Menu.builder()
                .name    (name)
                .url     (url)
                .sort    (sort)
                .children(children.stream()
                            .map(MenuRequest::toEntity)
                        .   collect(Collectors.toList()))
                .build();
    }
}
