package ru.vsu.Comparators;

public class PersonComparatorById implements PersonComparator {
    @Override
    public int compare(Object o1, Object o2) {
        if ((int) o1 - (int) o2 == 0) return 0;
        return (int) o1 - (int) o2 > 0 ? 1 : -1;
    }
}
