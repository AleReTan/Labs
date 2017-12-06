package ru.vsu.comparator.comparatorImpl;

import ru.vsu.entity.entityImpl.Person;

import java.util.Comparator;

public class PersonComparatorByAge implements Comparator<Person>{
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge() < 0 ? -1 : (o1.getAge() == o2.getAge() ? 0 : 1);
    }
}
