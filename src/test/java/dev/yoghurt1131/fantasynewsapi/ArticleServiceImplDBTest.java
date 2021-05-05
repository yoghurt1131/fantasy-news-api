package dev.yoghurt1131.fantasynewsapi;

import dev.yoghurt1131.fantasynewsapi.service.ArticleService;
import dev.yoghurt1131.fantasynewsapi.service.ArticleServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MongoDBImportInterceptor.class)
public class ArticleServiceImplDBTest extends FantasyNewsApiApplicationDBTests {

    @Autowired
    ReactiveMongoTemplate reactiveMongoTemplate;

    @TestMongoImport(filename = "article_service_init.json", collection = "articles")
    @Test
    void test_getTopArticles() {
        ArticleService target = new ArticleServiceImpl(reactiveMongoTemplate);
        var actual = target.getTopArticles();
        var articles = actual.collectList().block();

        // assert size of articles
        assertEquals(5, articles.size());

        // assert content of articles
        assertEquals(LocalDate.of(2021, 5, 8), articles.get(0).postedAt().toLocalDate());
        assertEquals(LocalDate.of(2021, 5, 7), articles.get(1).postedAt().toLocalDate());
        assertEquals(LocalDate.of(2021, 5, 6), articles.get(2).postedAt().toLocalDate());
        assertEquals(LocalDate.of(2021, 5, 5), articles.get(3).postedAt().toLocalDate());
        assertEquals(LocalDate.of(2021, 5, 4), articles.get(4).postedAt().toLocalDate());
    }
}
