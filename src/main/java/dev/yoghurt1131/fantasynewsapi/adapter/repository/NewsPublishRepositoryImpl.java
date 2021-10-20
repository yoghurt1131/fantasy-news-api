package dev.yoghurt1131.fantasynewsapi.adapter.repository;

import dev.yoghurt1131.fantasynewsapi.domain.Article;
import dev.yoghurt1131.fantasynewsapi.domain.Author;
import dev.yoghurt1131.fantasynewsapi.infrastructure.database.input.ArticleDbRecord;
import dev.yoghurt1131.fantasynewsapi.infrastructure.database.input.AuthorDbRecord;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

@Repository
public class NewsPublishRepositoryImpl implements NewsPublishRepository {

    private final MongoTemplate mongoTemplate;

    public NewsPublishRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void saveAuthor(Author author) {
        AuthorDbRecord record = AuthorDbRecord.builder()
                .id(author.getId().toString())
                .name(author.getName())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        mongoTemplate.insert(record);
    }

    @Override
    public boolean existsAuthor(Author author) {
        Query query = Query.query(Criteria
                    .where("id").is(author.getId())
                    .and("name").is(author.getName()));
        Optional<AuthorDbRecord> record = Optional.ofNullable(mongoTemplate.findOne(query, AuthorDbRecord.class));
        return record.isPresent();
    }

    @Override
    public void saveArticle(Article article) {
        ArticleDbRecord record = ArticleDbRecord.builder()
                .id(article.getArticleId().toString())
                .title(article.getTitle())
                .body(article.getBody())
                .authorId(article.getAuthor().getId().toString())
                .authorName(article.getAuthor().getName())
                .imageUrl(article.getImageUrl())
                .categories(article.getCategories())
                .version(1)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .comments(Collections.emptyList())
                .build();
        mongoTemplate.insert(record);
    }
}
