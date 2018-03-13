package ru.vsu;

import ru.vsu.annotation.AutoInjection;
import ru.vsu.util.Configurator;

import java.lang.reflect.Field;

public class Injector<T> {

    public T inject(T t) {
        for (Field field : t.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(AutoInjection.class)) {
                try {
                    field.setAccessible(true);
                    field.set(t, Configurator.getInstance().getFieldValue(field.getType().getName()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return t;
    }
}
