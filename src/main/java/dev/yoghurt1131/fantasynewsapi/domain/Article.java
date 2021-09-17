package dev.yoghurt1131.fantasynewsapi.domain;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
public class Article {

    private UUID articleId;

    private String title;

    private String body;

    private String imageUrl;

    private Author author;

    private List<Comment> comments;

    private List<Category> categories;

    private LocalDateTime publishedAt;

    private int pageview;

}
