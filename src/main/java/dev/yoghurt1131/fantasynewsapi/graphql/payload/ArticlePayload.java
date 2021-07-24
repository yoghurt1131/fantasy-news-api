package dev.yoghurt1131.fantasynewsapi.graphql.payload;

import dev.yoghurt1131.fantasynewsapi.graphql.ArticleCategory;

import java.util.List;
import java.util.UUID;

public record ArticlePayload(
        UUID articleId,
        String title,
        String body,
        AuthorPayload author,
        String imageUrl,
        List<ArticleCategory> categories,
        String publishedAt,
        List<CommentPayload> comments,
        int pageViews,
        int version
) {
}
