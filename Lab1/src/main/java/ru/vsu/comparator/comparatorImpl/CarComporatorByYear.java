package ru.vsu.comparator.comparatorImpl;

import ru.vsu.entity.entityImpl.Car;

import java.util.Comparator;

public class CarComporatorByYear implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getCarYearManufacture() - o2.getCarYearManufacture() < 0 ? -1 : (o1.getCarYearManufacture() == o2.getCarYearManufacture() ? 0 : 1);
    }
}
