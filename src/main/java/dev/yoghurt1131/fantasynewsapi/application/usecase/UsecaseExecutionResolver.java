package dev.yoghurt1131.fantasynewsapi.application.usecase;

import java.util.function.Supplier;

@FunctionalInterface
public interface UsecaseExecutionResolver {

    <T> T resolve(Supplier<T> supplier);

}
