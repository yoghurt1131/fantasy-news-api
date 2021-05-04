package dev.yoghurt1131.fantasynewsapi.service;

import dev.yoghurt1131.fantasynewsapi.model.Article;
import reactor.core.publisher.Flux;

public interface ArticleService {

    Flux<Article> getTopArticles();
}
