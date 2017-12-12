package ru.vsu.comparator.comparatorImpl;

import ru.vsu.entity.entityImpl.Car;

import java.util.Comparator;

public class CarComporatorByPrice implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getPrice() - o2.getPrice() < 0 ? -1 : (o1.getPrice() == o2.getPrice() ? 0 : 1);
    }
}
