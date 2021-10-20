package dev.yoghurt1131.fantasynewsapi.configurations.beanconfig;

import dev.yoghurt1131.fantasynewsapi.adapter.repository.NewsPublishRepository;
import dev.yoghurt1131.fantasynewsapi.adapter.repository.NewsPublishRepositoryImpl;
import dev.yoghurt1131.fantasynewsapi.application.usecase.*;
import dev.yoghurt1131.fantasynewsapi.application.usecase.publish.NewsPublishUsecase;
import dev.yoghurt1131.fantasynewsapi.application.usecase.publish.NewsPublishUsecaseAdapter;
import dev.yoghurt1131.fantasynewsapi.application.usecase.publish.NewsPublishUsecaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@Configuration
public class ApplicationConfig {

    @Bean
    public NewsPublishRepository newsPublishRepository(MongoTemplate mongoTemplate) {
        return new NewsPublishRepositoryImpl(mongoTemplate);
    }

    @Bean
    public UsecaseExceptionFilterChain usecaseExceptionFilterChain(List<UsecaseExceptionFilter> filters) {
        return new DefaultUsecaseExceptionFilterChain(filters);
    }

    @Bean
    public UsecaseExecutionResolver usecaseExecutionResolver(UsecaseExceptionFilterChain usecaseExceptionFilterChain) {
        return new UsecaseExecutionResolverAdapter(usecaseExceptionFilterChain);
    }

    @Bean
    public NewsPublishUsecase newsPublishUsecase(UsecaseExecutionResolver usecaseExecutionResolver, NewsPublishRepository newsPublishRepository) {
        return new NewsPublishUsecaseAdapter(new NewsPublishUsecaseImpl(newsPublishRepository), usecaseExecutionResolver);
    }
}
