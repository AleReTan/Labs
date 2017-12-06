package ru.vsu;

import ru.vsu.sorter.PersonSorter;
import ru.vsu.sorter.sorterImpl.BubblePersonSorter;

public class Configurator {
    private static Configurator instance;

    private Configurator() {
    }

    public PersonSorter getSorter() {

        return new BubblePersonSorter();// заглушка, сюда парсинг из пропертиес
    }

    public static Configurator getInstance() {
        if (instance == null) {
            instance = new Configurator();
        }
        return instance;
    }
}
