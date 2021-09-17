package dev.yoghurt1131.fantasynewsapi.application;

import dev.yoghurt1131.fantasynewsapi.adapter.resolver.input.CreateArticleInput;
import dev.yoghurt1131.fantasynewsapi.adapter.repository.NewsPublishRepository;
import dev.yoghurt1131.fantasynewsapi.domain.Article;
import dev.yoghurt1131.fantasynewsapi.domain.ArticleHistory;
import dev.yoghurt1131.fantasynewsapi.domain.Author;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class NewsPublishUsecaseImpl implements NewsPublishUsecase {

    private final NewsPublishRepository repository;

    @Override
    public Author createAuthor(String name) {
        // TODO 名前に(バリデーション以外の)なにか縛りがあるならここで記述
        Author author = Author.builder()
                .id(UUID.randomUUID())
                .name(name)
                .build();
        return repository.saveAuthor(author);
    }

    @Override
    public Article createArticle(CreateArticleInput articleInput) {
        return null;
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
