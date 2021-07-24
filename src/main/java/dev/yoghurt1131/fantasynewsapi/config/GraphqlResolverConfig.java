package dev.yoghurt1131.fantasynewsapi.config;

import dev.yoghurt1131.fantasynewsapi.resolver.ArticleQueryResolver;
import dev.yoghurt1131.fantasynewsapi.resolver.FantasyNewsApiMutationResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlResolverConfig {

    @Bean
    public ArticleQueryResolver articleQueryResolver() {
        return new ArticleQueryResolver();
    }

    @Bean
    public FantasyNewsApiMutationResolver fantasyNewsApiMutationResolver() {
        return new FantasyNewsApiMutationResolver();
    }
}
