package ru.vsu.searcher.searcherImpl;

import ru.vsu.entity.entityImpl.Person;
import ru.vsu.searcher.PersonChecker;

public class AgePersonChecker implements PersonChecker{
    @Override
    public boolean check(Person p, Object value) {
        return p.getAge().equals(value);
    }
}
