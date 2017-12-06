package ru.vsu.searcher;

import ru.vsu.entity.entityImpl.Person;

@FunctionalInterface
public interface PersonChecker {

    public boolean check(Person p, Object value);

}
