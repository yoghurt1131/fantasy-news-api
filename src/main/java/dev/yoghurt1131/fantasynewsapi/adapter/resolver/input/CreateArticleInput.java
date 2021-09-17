package dev.yoghurt1131.fantasynewsapi.adapter.resolver.input;

import dev.yoghurt1131.fantasynewsapi.domain.Category;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record CreateArticleInput(
        String title,
        String body,
        UUID authorId,
        String authorName,
        String imageUrl,
        List<Category> categories,
        LocalDateTime publishAt
) {
}
