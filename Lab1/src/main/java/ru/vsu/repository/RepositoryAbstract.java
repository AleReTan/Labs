package ru.vsu.repository;

import ru.vsu.sorter.Sorter;

import java.util.Arrays;

public abstract class RepositoryAbstract<T> implements Repository<T> {
    protected static double EXTEND_COEFFICIENT = 1.2;
    protected static int INITIAL_SIZE = 1;
    protected Object[] repository;
    protected int size;//размер массива
    protected int capacity;//количество элементов в массиве
    protected Sorter sorter;

    public T[] getRepository() {
        return (T[]) repository;
    }

    @Override
    public T get(int index) {
        if (index < repository.length) {
            return (T) repository[index];
        } else {
            System.out.println("This index bigger than repository capacity");//
            return null;
        }
    }

    @Override
    public T[] getAll() {
        return (T[]) repository;
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
            trimToSize();

        } else System.out.println("This index bigger than repository capacity");

    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    protected void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    protected void extend() {
        size = (int) (size * EXTEND_COEFFICIENT) + 1;
        repository = Arrays.copyOf(this.repository, size);
    }

    protected void trimToSize() {
        this.repository = Arrays.copyOf(this.repository, capacity);
    }


}
