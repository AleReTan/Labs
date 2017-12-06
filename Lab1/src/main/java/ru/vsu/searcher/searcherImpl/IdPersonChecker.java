package ru.vsu.searcher.searcherImpl;

import ru.vsu.entity.entityImpl.Person;
import ru.vsu.searcher.PersonChecker;

public class IdPersonChecker implements PersonChecker {
    @Override
    public boolean check(Person p, Object value) {
        return Integer.valueOf(p.getId()).equals(value);//TODO: спросить, пойдет так или нет
    }
}
