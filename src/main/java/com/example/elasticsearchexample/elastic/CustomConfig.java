package com.example.elasticsearchexample.elastic;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
@ConfigurationProperties(prefix = "elastic.search")
@Data
public class CustomConfig {

    private String domain;
}
