package ru.vsu.sorter;

import ru.vsu.entity.entityImpl.Person;

import java.util.Comparator;

public interface PersonSorter {
    void sort(Person[] array, Comparator comparator);
}
