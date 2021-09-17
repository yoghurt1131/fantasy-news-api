package dev.yoghurt1131.fantasynewsapi.adapter.resolver.payload;

import java.util.UUID;

public record AuthorPayload(
        UUID authorId,
        String name
) {
}
