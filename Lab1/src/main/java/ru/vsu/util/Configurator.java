package ru.vsu.util;

import ru.vsu.entity.entityImpl.Car;
import ru.vsu.entity.entityImpl.Person;
import ru.vsu.sorter.Sorter;
import ru.vsu.sorter.sorterImpl.BubbleCarSorter;
import ru.vsu.sorter.sorterImpl.BubblePersonSorter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configurator {
    private static Configurator instance;

    private Configurator() {
    }

    public Sorter getCarSorter() {
        //String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();//TODO: падает если запустить дебаг, как лечить
        String appConfigPath = "/Users/alexresh/IdeaProjects/Labs/Lab1/src/main/resources/" + "configuration.properties";

        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String appSorter = appProps.getProperty("carSorter");
        switch (appSorter) {
            case "bubble":
                return new BubbleCarSorter();
            default:
                return new BubbleCarSorter();
        }
    }

    public Sorter getPersonSorter() {
        //String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();//TODO: падает если запустить дебаг, как лечить
        String appConfigPath = "/Users/alexresh/IdeaProjects/Labs/Lab1/src/main/resources/" + "configuration.properties";

        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String appSorter = appProps.getProperty("personSorter");
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
