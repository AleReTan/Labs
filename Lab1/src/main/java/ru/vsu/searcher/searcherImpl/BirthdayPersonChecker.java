package ru.vsu.searcher.searcherImpl;

import ru.vsu.entity.entityImpl.Person;
import ru.vsu.searcher.PersonChecker;

public class BirthdayPersonChecker implements PersonChecker{
    @Override
    public boolean check(Person p, Object value) {
        return p.getBirthday() != null && p.getBirthday().equals(value);
    }
}
