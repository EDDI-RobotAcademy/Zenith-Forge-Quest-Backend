package com.cafe.backend.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "Zenith Forge Quest Project",
                description = "Zenith Forge Quest Project API 명세",
                version = "v1"))
@Configuration
public class SwaggerConfig {
}
