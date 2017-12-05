package ru.vsu.Comparators;

import ru.vsu.Entities.Person;

public class PersonComparatorByFio implements PersonComparator {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }

    @Override
    public int compare(Object o1, Object o2) {
        Person p1=(Person)o1;
        Person p2=(Person)o2;
        return p1.getLastName().compareTo(p2.getLastName());
    }

}
