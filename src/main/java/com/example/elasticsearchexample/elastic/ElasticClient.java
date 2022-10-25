package com.example.elasticsearchexample.elastic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ElasticClient {

    private final CustomConfig config;

    @Bean
    public RestHighLevelClient setElasticSearchClient() {
        log.info(String.format("elastichsearch host: %s", config.getDomain()));

        return new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(config.getDomain(), 9200, "http")
                ));
    }
}
