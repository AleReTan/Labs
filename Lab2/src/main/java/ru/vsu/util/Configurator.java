package ru.vsu.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class Configurator {
    private static Configurator instance;

    private Configurator() {
    }

    public Object getFieldValue(String clazz) {
        //String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();//TODO: падает если запустить дебаг, как лечить
        String appConfigPath = "/Users/alexresh/IdeaProjects/Labs/Lab2/src/main/resources/" + "configuration.properties";

        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String classValue = appProps.getProperty(clazz);
        try {
            return Class.forName(classValue).getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static Configurator getInstance() {
        if (instance == null) {
            instance = new Configurator();
        }
        return instance;
    }
}
