package dev.yoghurt1131.fantasynewsapi.application.usecase;

import reactor.core.publisher.Mono;

import java.util.List;
import java.util.ListIterator;

public class DefaultUsecaseExceptionFilterChain implements UsecaseExceptionFilterChain {

    private final List<UsecaseExceptionFilter> allFilters;

    private final UsecaseExceptionFilter currentFilter;

    private final DefaultUsecaseExceptionFilterChain chain;

    public DefaultUsecaseExceptionFilterChain(List<UsecaseExceptionFilter> filters) {
        this.allFilters = filters;
        DefaultUsecaseExceptionFilterChain chain = initChain(filters);
        this.currentFilter = chain.currentFilter;
        this.chain = chain.chain;
    }

    private static DefaultUsecaseExceptionFilterChain initChain(List<UsecaseExceptionFilter> filters) {
        DefaultUsecaseExceptionFilterChain chain = new DefaultUsecaseExceptionFilterChain(filters, null, null);
        ListIterator<? extends UsecaseExceptionFilter> iterator = filters.listIterator(filters.size());
        while(iterator.hasPrevious()) {
            chain = new DefaultUsecaseExceptionFilterChain(filters, iterator.previous(), chain);
        }
        return chain;
    }

    private DefaultUsecaseExceptionFilterChain(List<UsecaseExceptionFilter> allFilters, UsecaseExceptionFilter currentFilter, DefaultUsecaseExceptionFilterChain chain) {
        this.allFilters = allFilters;
        this.currentFilter = currentFilter;
        this.chain = chain;
    }


    @Override
    public <T> Mono<T> filter(Throwable throwable) {
        if(currentFilter != null && chain != null) {
            currentFilter.filter(throwable, chain);
        }
        return Mono.error(throwable);
    }
}
