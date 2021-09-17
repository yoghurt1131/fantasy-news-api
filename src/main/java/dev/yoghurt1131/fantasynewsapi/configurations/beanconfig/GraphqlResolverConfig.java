package dev.yoghurt1131.fantasynewsapi.configurations.beanconfig;

import dev.yoghurt1131.fantasynewsapi.adapter.resolver.scalar.LocalDateTimeScalar;
import dev.yoghurt1131.fantasynewsapi.adapter.resolver.ArticleQueryResolver;
import dev.yoghurt1131.fantasynewsapi.adapter.resolver.FantasyNewsApiMutationResolver;
import dev.yoghurt1131.fantasynewsapi.application.NewsPublishUsecase;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlResolverConfig {

    @Bean
    public GraphQLScalarType localDateTimeScalar() {
        return GraphQLScalarType.newScalar()
                .name("LocalDateTime")
                .coercing(new LocalDateTimeScalar.LocalDateTimeCoercing())
                .build();
    }

    @Bean
    public ArticleQueryResolver articleQueryResolver() {
        return new ArticleQueryResolver();
    }

    @Bean
    public FantasyNewsApiMutationResolver fantasyNewsApiMutationResolver(NewsPublishUsecase publishUsecase) {
        return new FantasyNewsApiMutationResolver(publishUsecase);
    }
}
