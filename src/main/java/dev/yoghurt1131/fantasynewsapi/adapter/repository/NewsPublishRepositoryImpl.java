package dev.yoghurt1131.fantasynewsapi.adapter.repository;

import dev.yoghurt1131.fantasynewsapi.domain.Author;
import dev.yoghurt1131.fantasynewsapi.infrastructure.database.input.AuthorDbRecord;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.UUID;

@Repository
public class NewsPublishRepositoryImpl implements NewsPublishRepository {

    private final MongoTemplate mongoTemplate;

    public NewsPublishRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Author saveAuthor(Author author) {
        AuthorDbRecord record = AuthorDbRecord.builder()
                .id(author.getId().toString())
                .name(author.getName())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        AuthorDbRecord inserted = mongoTemplate.insert(record);
        return Author.builder()
                .id(UUID.fromString(inserted.getId()))
                .name(inserted.getName())
                .build();
    }
}
