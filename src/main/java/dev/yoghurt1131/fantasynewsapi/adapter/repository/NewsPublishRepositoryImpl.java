package dev.yoghurt1131.fantasynewsapi.adapter.repository;

import dev.yoghurt1131.fantasynewsapi.domain.Author;
import dev.yoghurt1131.fantasynewsapi.infrastructure.database.input.AuthorDbRecord;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class NewsPublishRepositoryImpl implements NewsPublishRepository {
    @Override
    public Author saveAuthor(Author author) {
        AuthorDbRecord record = AuthorDbRecord.builder()
                .id(author.getId())
                .name(author.getName())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return author;
    }
}
