package ru.vsu.comparator.comparatorImpl;

import ru.vsu.entity.entityImpl.Car;

import java.util.Comparator;

public class CarComporatorById implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getId() - o2.getId() < 0 ? -1 : (o1.getId() == o2.getId() ? 0 : 1);
    }
}


