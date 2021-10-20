package dev.yoghurt1131.fantasynewsapi.application.usecase;


import reactor.core.publisher.Mono;

@FunctionalInterface
public interface UsecaseExceptionFilterChain {

    <T> Mono<T> filter(Throwable throwable);

}
