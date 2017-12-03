package ru.vsu.Comparators;

import java.util.Comparator;

public interface PersonComparator extends Comparator {

    @Override
    int compare(Object o1, Object o2);
}
