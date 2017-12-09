package ru.vsu.repository;


import ru.vsu.entity.entityImpl.Person;

import java.util.Arrays;

public abstract class RepositoryAbstract<T> implements Repository<T> {
    private static double EXTEND_COEFFICIENT = 1.2;
    private T[] repository;
    private int size;
    private int capacity;

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

    @Override
    public void extend() {
        size *= EXTEND_COEFFICIENT + 1;
        T[] newRepository = Arrays.copyOf(repository, size);
        System.arraycopy(repository, 0, newRepository, 0, repository.length);
        repository = newRepository;//TODO: чет чушь, надо править
    }

}
