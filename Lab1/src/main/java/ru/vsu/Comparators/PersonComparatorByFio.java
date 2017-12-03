package ru.vsu.Comparators;

public class PersonComparatorByFio implements PersonComparator {
    @Override
    public int compare(Object o1, Object o2) {
        if (o1.equals(o2)) return 0;
        return 0;  //придумать как сравнивать по
    }
}
