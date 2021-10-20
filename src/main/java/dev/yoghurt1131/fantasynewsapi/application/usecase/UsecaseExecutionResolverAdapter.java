package dev.yoghurt1131.fantasynewsapi.application.usecase;

import reactor.core.publisher.Mono;

import java.util.function.Supplier;

public class UsecaseExecutionResolverAdapter implements UsecaseExecutionResolver {

    private final UsecaseExceptionFilterChain filterChain;

    public UsecaseExecutionResolverAdapter(UsecaseExceptionFilterChain filterChain) {
        this.filterChain = filterChain;
    }

    @Override
    public <T> T resolve(Supplier<T> supplier) {
        return Mono
                .fromSupplier(supplier)
                .onErrorResume(throwable -> filterChain.filter(throwable))
                .block();
    }

}