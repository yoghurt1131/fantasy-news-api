package dev.yoghurt1131.fantasynewsapi.application.usecase;

import reactor.core.publisher.Mono;

public interface UsecaseExceptionFilter {

    <T> Mono<T> filter(Throwable throwable, UsecaseExceptionFilterChain chain);
}
