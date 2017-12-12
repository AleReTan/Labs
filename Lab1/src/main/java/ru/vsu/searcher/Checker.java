package ru.vsu.searcher;

@FunctionalInterface
public interface Checker<T> {
    public boolean check(T t, Object value);
}
