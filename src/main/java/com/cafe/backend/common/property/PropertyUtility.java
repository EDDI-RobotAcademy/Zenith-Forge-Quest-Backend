package com.cafe.backend.common.property;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@RequiredArgsConstructor
@PropertySource(value = "classpath:application.properties")
public class PropertyUtility {

    final private Environment environment;

    public String getProperty(String key) {
        return environment.getProperty(key);
    }
}
