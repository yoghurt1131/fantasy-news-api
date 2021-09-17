package dev.yoghurt1131.fantasynewsapi.adapter.repository;

import dev.yoghurt1131.fantasynewsapi.domain.Author;

public interface NewsPublishRepository {

    Author saveAuthor(Author author);
}
