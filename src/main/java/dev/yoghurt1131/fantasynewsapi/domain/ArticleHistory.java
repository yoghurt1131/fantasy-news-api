package dev.yoghurt1131.fantasynewsapi.domain;

import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public class ArticleHistory {

    private UUID articleId;

    private int version;

    private String title;

    private String body;

    private String imageUrl;

    private List<Category> categories;
}
