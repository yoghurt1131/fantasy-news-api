package dev.yoghurt1131.fantasynewsapi.domain;

import dev.yoghurt1131.fantasynewsapi.adapter.resolver.payload.AuthorPayload;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class Author {

    private UUID id;

    private String name;

    public AuthorPayload buildPayload() {
        return new AuthorPayload(id, name);
    }
}
