package ru.vsu.util;

import ru.vsu.sorter.PersonSorter;
import ru.vsu.sorter.sorterImpl.BubblePersonSorter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configurator {
    private static Configurator instance;

    private Configurator() {
    }

    public PersonSorter getSorter() {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();//TODO: падает если запустить дебаг, как лечить
        String appConfigPath = rootPath + "configuration.properties";

        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String appSorter = appProps.getProperty("sorter");
        switch (appSorter) {
            case "bubble":
                return new BubblePersonSorter();
            default:
                return new BubblePersonSorter();
        }
    }

    public static Configurator getInstance() {
        if (instance == null) {
            instance = new Configurator();
        }
        return instance;
    }
}
