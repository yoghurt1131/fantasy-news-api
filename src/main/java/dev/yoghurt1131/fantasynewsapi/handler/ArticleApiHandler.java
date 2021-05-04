package dev.yoghurt1131.fantasynewsapi.handler;

import dev.yoghurt1131.fantasynewsapi.model.Article;
import dev.yoghurt1131.fantasynewsapi.service.ArticleService;
import dev.yoghurt1131.fantasynewsapi.service.ArticleServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class ArticleApiHandler {

    private final ArticleService articleService;

    public ArticleApiHandler(ArticleService articleService) {
        this.articleService = articleService;
    }

    public Mono<ServerResponse> getTopArticles(ServerRequest serverRequest) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(articleService.getTopArticles(), Article.class);
    }
}
