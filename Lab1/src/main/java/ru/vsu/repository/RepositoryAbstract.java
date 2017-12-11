package ru.vsu.repository;

import java.util.Arrays;

public abstract class RepositoryAbstract<T> implements Repository<T> {
    private static double EXTEND_COEFFICIENT = 1.2;
    private static int INITIAL_SIZE = 2;
    private T[] repository;
    private int size;//размер массива
    private int capacity;//количество элементов в массиве

    public T[] getRepository(){
        return repository;
    }

    @Override
    public T get(int index) {
        if (index < repository.length) {
            return repository[index];
        } else {
            System.out.println("This index bigger than repository capacity");//
            return null;
        }
    }

    @Override
    public T[] getAll() {
        return repository;
    }

    @Override
    public void add(T t) {
        if (capacity + 1 > size) {
            extend();
        }
        repository[capacity] = t;
        capacity++;
        trimToSize();
    }

    @Override
    public void remove(int index) {
        if (index < capacity) {
            System.arraycopy(repository, index + 1, repository, index, size - 1 - index);
            repository[size - 1] = null;
            capacity--;

        } else System.out.println("This index bigger than repository capacity");

    }

    private void extend() {
        size *= EXTEND_COEFFICIENT + 1;
        repository = Arrays.copyOf(this.repository, size);
    }

    private void trimToSize() {
        this.repository = Arrays.copyOf(this.repository, capacity);
    }
}
