package ru.vsu.searcher.searcherImpl;

import ru.vsu.entity.entityImpl.Person;
import ru.vsu.searcher.Checker;


public class IdPersonChecker implements Checker<Person> {
    @Override
    public boolean check(Person p, Object value) {
        return Integer.valueOf(p.getId()).equals(value);//TODO: спросить, пойдет так или нет
    }
}
