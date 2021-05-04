package dev.yoghurt1131.fantasynewsapi.service;

import dev.yoghurt1131.fantasynewsapi.model.Article;
import dev.yoghurt1131.fantasynewsapi.model.ArticleRecord;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ReactiveMongoTemplate mongoTemplate;

    public ArticleServiceImpl(ReactiveMongoTemplate reactiveMongoTemplate) {
        this.mongoTemplate = reactiveMongoTemplate;
    }

    public Flux<Article> getTopArticles() {
        var query = new Query()
                .with(Sort.by(Sort.Direction.DESC, "posted_at"))
                .limit(5);
        return mongoTemplate
                .find(query, ArticleRecord.class)
                .map(Article::build);
    }
}
