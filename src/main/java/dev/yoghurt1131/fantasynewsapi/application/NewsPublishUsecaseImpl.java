package dev.yoghurt1131.fantasynewsapi.application;

import dev.yoghurt1131.fantasynewsapi.adapter.resolver.input.CreateArticleInput;
import dev.yoghurt1131.fantasynewsapi.adapter.repository.NewsPublishRepository;
import dev.yoghurt1131.fantasynewsapi.domain.Article;
import dev.yoghurt1131.fantasynewsapi.domain.ArticleHistory;
import dev.yoghurt1131.fantasynewsapi.domain.Author;
import graphql.GraphQLException;
import graphql.GraphqlErrorException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class NewsPublishUsecaseImpl implements NewsPublishUsecase {

    private final NewsPublishRepository repository;

    @Override
    public Author createAuthor(String name) {
        Author author = Author.builder()
                .id(UUID.randomUUID())
                .name(name)
                .build();
        repository.saveAuthor(author);
        return author;
    }

    @Override
    public Article createArticle(CreateArticleInput articleInput) {
        Author author = Author.builder()
                .id(articleInput.authorId())
                .name(articleInput.authorName())
                .build();
        if(!repository.existsAuthor(author)) {
            throw new GraphqlErrorException.Builder()
                    .message("Author does not exist")
                    .build();
        }
        Article article = Article.builder()
                .articleId(UUID.randomUUID())
                .title(articleInput.title())
                .body(articleInput.body())
                .author(author)
                .imageUrl(articleInput.imageUrl())
                .categories(articleInput.categories())
                .publishedAt(articleInput.publishAt())
                .build();
        repository.saveArticle(article);
        return article;
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
