package com.cafe.backend.menu.service.dto;

import lombok.Builder;

@Builder
public record MenuPageRequest(
        String name
) {
}
