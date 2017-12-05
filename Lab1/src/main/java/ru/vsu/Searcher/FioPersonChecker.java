package ru.vsu.Searcher;

import ru.vsu.Entities.Person;

public class FioPersonChecker implements PersonChecker{
    @Override
    public boolean check(Person p, Object value) {
        return p.getLastName().equals(value);
    }
}
