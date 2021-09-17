package dev.yoghurt1131.fantasynewsapi.adapter.resolver.payload;

import dev.yoghurt1131.fantasynewsapi.domain.Category;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record ArticlePayload(
        UUID articleId,
        String title,
        String body,
        AuthorPayload author,
        String imageUrl,
        List<Category> categories,
        LocalDateTime publishedAt,
        List<CommentPayload> comments,
        int pageViews,
        int version
) {
}
