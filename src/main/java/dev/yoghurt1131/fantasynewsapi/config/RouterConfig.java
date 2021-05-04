package dev.yoghurt1131.fantasynewsapi.config;

import dev.yoghurt1131.fantasynewsapi.handler.ArticleApiHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> router(ArticleApiHandler articleHandler) {
        return route()
                .GET("/topics", accept(MediaType.APPLICATION_JSON), articleHandler::getTopArticles)
                .build();
    }
}
