package dev.yoghurt1131.fantasynewsapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(value = "articles")
public record ArticleRecord(
        @Id
        String id,
        String title,
        String headline,
        String image_url,
        String body,
        String author,
        LocalDateTime posted_at,
        LocalDateTime created_at,
        LocalDateTime updated_at
) {
}
