package dev.yoghurt1131.fantasynewsapi.application.usecase.publish;

import dev.yoghurt1131.fantasynewsapi.adapter.resolver.input.CreateArticleInput;
import dev.yoghurt1131.fantasynewsapi.application.usecase.UsecaseExecutionResolver;
import dev.yoghurt1131.fantasynewsapi.domain.Article;
import dev.yoghurt1131.fantasynewsapi.domain.ArticleHistory;
import dev.yoghurt1131.fantasynewsapi.domain.Author;

import java.util.List;
import java.util.UUID;

public class NewsPublishUsecaseAdapter implements NewsPublishUsecase {

    private final NewsPublishUsecaseImpl newsPublishUsecase;

    private final UsecaseExecutionResolver resolver;

    public NewsPublishUsecaseAdapter(NewsPublishUsecaseImpl newsPublishUsecase, UsecaseExecutionResolver resolver) {
        this.newsPublishUsecase = newsPublishUsecase;
        this.resolver = resolver;
    }

    @Override
    public Author createAuthor(String name) {
        return resolver.resolve(() -> this.newsPublishUsecase.createAuthor(name));
    }

    @Override
    public Article createArticle(CreateArticleInput articleInput) {
        // return resolver.resolve(() -> this.newsPublishUsecase.createArticle(articleInput));
        return this.newsPublishUsecase.createArticle(articleInput);
    }

    @Override
    public Article showArticleById(UUID articleId) {
        return null;
    }

    @Override
    public List<ArticleHistory> getArticleHistory(UUID articleId) {
        return null;
    }
}
