package ru.vsu.searcher.searcherImpl;

import ru.vsu.entity.entityImpl.Person;
import ru.vsu.searcher.Checker;

public class BirthdayPersonChecker implements Checker<Person>{
    @Override
    public boolean check(Person p, Object value) {
        return p.getBirthday() != null && p.getBirthday().equals(value);
    }
}
