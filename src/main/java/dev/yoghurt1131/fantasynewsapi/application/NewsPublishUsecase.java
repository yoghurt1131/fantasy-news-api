package dev.yoghurt1131.fantasynewsapi.application;

import dev.yoghurt1131.fantasynewsapi.adapter.resolver.input.CreateArticleInput;
import dev.yoghurt1131.fantasynewsapi.domain.Article;
import dev.yoghurt1131.fantasynewsapi.domain.ArticleHistory;
import dev.yoghurt1131.fantasynewsapi.domain.Author;

import java.util.List;
import java.util.UUID;

public interface NewsPublishUsecase {

    Author createAuthor(String name);

    Article createArticle(CreateArticleInput articleInput);

    Article showArticleById(UUID articleId);

    List<ArticleHistory> getArticleHistory(UUID articleId);
}
