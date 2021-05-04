package dev.yoghurt1131.fantasynewsapi;

import com.mongodb.ConnectionString;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(FantasyNewsApiApplication.class, args);
    }

    @Primary
    @Bean
    public ReactiveMongoTemplate testReactiveMongoTemplate() {
        MongoClient mongoClient = MongoClients.create(new ConnectionString("mongodb://localhost:9999"));
        ReactiveMongoTemplate reactiveMongoTemplate = new ReactiveMongoTemplate(mongoClient, "test");
        return reactiveMongoTemplate;
    }
}
