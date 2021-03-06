package ru.vsu.sorter.sorterImpl;

import ru.vsu.entity.entityImpl.Person;
import ru.vsu.sorter.Sorter;

import java.util.Comparator;

public class BubblePersonSorter implements Sorter {
    @Override
    public void sort(Object[] array, Comparator comparator) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    Person temp = (Person) array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
