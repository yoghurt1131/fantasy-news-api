package dev.yoghurt1131.fantasynewsapi;

import com.mongodb.ConnectionString;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import dev.yoghurt1131.fantasynewsapi.handler.ArticleApiHandler;
import dev.yoghurt1131.fantasynewsapi.model.ArticleRecord;
import dev.yoghurt1131.fantasynewsapi.service.ArticleService;
import dev.yoghurt1131.fantasynewsapi.service.ArticleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.mock.web.reactive.function.server.MockServerRequest;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Flux;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArticleApiHandlerTest extends FantasyNewsApiApplicationDBTests {

    @Autowired
    ReactiveMongoTemplate reactiveMongoTemplate;

    @Test
    void contextLoads() throws Exception {
        Flux<ArticleRecord> records = reactiveMongoTemplate.findAll(ArticleRecord.class);
        assertEquals(0, records.count().block());
    }

    @Test
    void test_getTopArticles() {
        ArticleService articleService = new ArticleServiceImpl(reactiveMongoTemplate);
        ArticleApiHandler target = new ArticleApiHandler(articleService);
        target.getTopArticles(MockServerRequest.builder().build());
    }


}
