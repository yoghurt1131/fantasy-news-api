package dev.yoghurt1131.fantasynewsapi.graphql.payload;

import java.util.List;
import java.util.UUID;

public record CommentPayload(
        UUID commentId,
        UUID articleId,
        String body,
        String user,
        String postedAt,
        List<CommentPayload> comments
) {
}
