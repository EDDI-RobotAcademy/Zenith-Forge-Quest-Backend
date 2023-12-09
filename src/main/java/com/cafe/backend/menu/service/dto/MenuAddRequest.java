package com.cafe.backend.menu.service.dto;

import com.cafe.backend.menu.entity.Menu;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;

@Builder
public record MenuAddRequest(
        String name,
        String url,
        Long sort,
        List<MenuAddRequest> children
) {

    public Menu toEntity() {
        return Menu.builder()
                .name    (name)
                .url     (url)
                .sort    (sort)
                .children(children.stream()
                            .map(MenuAddRequest::toEntity)
                            .collect(Collectors.toList()))
                .build();
    }
}
