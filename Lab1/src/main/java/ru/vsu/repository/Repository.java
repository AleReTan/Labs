package ru.vsu.repository;

public interface Repository<T> {
    public T get(int index);
    public T[] getAll();
    public void add(T t);
    public void remove(int index);
    public void extend();
    public void trimToSize();

}
