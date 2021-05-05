package dev.yoghurt1131.fantasynewsapi;

import de.flapdoodle.embed.mongo.MongoImportExecutable;
import de.flapdoodle.embed.mongo.MongoImportProcess;
import de.flapdoodle.embed.mongo.MongoImportStarter;
import de.flapdoodle.embed.mongo.config.IMongoImportConfig;
import de.flapdoodle.embed.mongo.config.MongoImportConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import dev.yoghurt1131.fantasynewsapi.service.ArticleService;
import dev.yoghurt1131.fantasynewsapi.service.ArticleServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArticleServiceImplTest extends FantasyNewsApiApplicationDBTests {

    @Autowired
    ReactiveMongoTemplate reactiveMongoTemplate;

    @BeforeAll
    static void setup() throws Exception {
        String jsonFile = "src/test/resources/initialnews.json";
        IMongoImportConfig mongoImportConfig = new MongoImportConfigBuilder()
                .version(Version.Main.PRODUCTION)
                .net(new Net(TestMongoDB.port(), Network.localhostIsIPv6()))
                .db(TestMongoDB.dbname())
                .collection("articles")
                .upsert(true)
                .dropCollection(true)
                .jsonArray(true)
                .importFile(jsonFile)
                .build();
        MongoImportExecutable mongoImportExecutable = MongoImportStarter.getDefaultInstance().prepare(mongoImportConfig);
        // import execute
        MongoImportProcess mongoImport = mongoImportExecutable.start();

        mongoImport.stop();
    }

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
