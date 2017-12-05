package ru.vsu.Sorter;

import ru.vsu.Comparators.PersonComparator;
import ru.vsu.Entities.Person;

public interface PersonSorter {
    void sort(Person[] array, PersonComparator comparator);
}
