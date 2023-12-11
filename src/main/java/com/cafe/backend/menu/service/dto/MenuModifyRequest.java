package com.cafe.backend.menu.service.dto;

import com.cafe.backend.menu.entity.Menu;
import lombok.Builder;

@Builder
public record MenuModifyRequest(
        String name,
        String url,
        Long sort
) {
    public Menu toEntity() {
        return Menu.builder()
                .name(name)
                .url (url)
                .sort(sort)
                .build();
    }
}
