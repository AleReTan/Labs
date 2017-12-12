package ru.vsu.searcher.searcherImpl;

import ru.vsu.entity.entityImpl.Person;
import ru.vsu.searcher.Checker;

public class LastNamePersonChecker implements Checker<Person> {
    @Override
    public boolean check(Person p, Object value) {
        return p.getLastName().equals(value);
    }
}
