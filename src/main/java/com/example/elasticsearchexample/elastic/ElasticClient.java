package com.example.elasticsearchexample.elastic;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
@Slf4j
public class ElasticClient {

    private final RestHighLevelClient elasticSearchClient;

    public ElasticClient(@Value("${elastic.search.domain}") String elasticSearchDomain) {

        log.info(String.format("elastichsearch host: %s", elasticSearchDomain));

        this.elasticSearchClient = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(elasticSearchDomain, 9200, "http"),
                        new HttpHost(elasticSearchDomain, 9201, "http")
                ));

    }
}
