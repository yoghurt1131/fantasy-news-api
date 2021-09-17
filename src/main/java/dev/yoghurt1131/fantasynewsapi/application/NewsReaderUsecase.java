package dev.yoghurt1131.fantasynewsapi.application;

import dev.yoghurt1131.fantasynewsapi.domain.Category;
import dev.yoghurt1131.fantasynewsapi.domain.Article;
import dev.yoghurt1131.fantasynewsapi.domain.Comment;

import java.util.List;
import java.util.UUID;

public interface NewsReaderUsecase {

    List<Article> latestArticles(int limit);

    Article getArticleById(UUID id);

    List<Article> getArticlesByCategory(Category category);

    Comment postComment(UUID articleId, String body);
}
