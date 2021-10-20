package dev.yoghurt1131.fantasynewsapi.adapter.repository;

import dev.yoghurt1131.fantasynewsapi.domain.Article;
import dev.yoghurt1131.fantasynewsapi.domain.Author;

public interface NewsPublishRepository {

    void saveAuthor(Author author);

    boolean existsAuthor(Author author);

    void saveArticle(Article article);
}
