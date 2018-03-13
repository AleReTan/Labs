package ru.vsu.repository;

public interface Repository<T> {
    /**
     *
     * @param index
     * @return
     */
    public T get(int index);

    /**
     * @return
     */
    public T[] getAll();

    /**
     * @param t
     */
    public void add(T t);

    /**
     * @param index
     */
    public void remove(int index);
}
