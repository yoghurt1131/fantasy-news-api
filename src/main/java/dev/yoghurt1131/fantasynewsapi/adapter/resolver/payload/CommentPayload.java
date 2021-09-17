package dev.yoghurt1131.fantasynewsapi.adapter.resolver.payload;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record CommentPayload(
        UUID commentId,
        UUID articleId,
        String body,
        String user,
        LocalDateTime postedAt,
        List<CommentPayload> comments
) {
}
