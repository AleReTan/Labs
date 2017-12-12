package ru.vsu.repository.repositoryImpl;

import org.junit.Test;
import ru.vsu.entity.entityImpl.Car;

import static org.junit.Assert.*;

public class CarRepositoryTest {
    private Car car1 = new Car("BMW", 2000000, "black", 2007);
    private Car car2 = new Car("Audi", 1300000, "blue", 2013);
    private Car car3 = new Car("Lada", 700000, "red", 2015);
    private Car car4 = new Car("Mitsubishi", 1000000, "white", 2013);
    private Car car5 = new Car("Lexus", 6000000, "white", 2009);

    @Test
    public void testSortById() {
        CarRepository carRepository = new CarRepository();
        Car[] expected = new Car[3];
        expected[0] = car1;
        expected[1] = car2;
        expected[2] = car3;

        carRepository.add(car2);
        carRepository.add(car1);
        carRepository.add(car3);

        carRepository.sortById();
        Car[] actual = carRepository.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortByPrice() {
        CarRepository carRepository = new CarRepository();
        Car[] expected = new Car[3];
        expected[0] = car1;
        expected[1] = car4;
        expected[2] = car3;

        carRepository.add(car4);
        carRepository.add(car3);
        carRepository.add(car1);

        carRepository.sortByYear();
        Car[] actual = carRepository.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortByYear() {
        CarRepository carRepository = new CarRepository();
        Car[] expected = new Car[3];
        expected[0] = car3;
        expected[1] = car2;
        expected[2] = car5;

        carRepository.add(car2);
        carRepository.add(car5);
        carRepository.add(car3);

        carRepository.sortByPrice();
        Car[] actual = carRepository.getAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByColor() {
        CarRepository carRepository = new CarRepository();
        Car[] expected = new Car[2];
        expected[0] = car4;
        expected[1] = car5;

        carRepository.add(car1);
        carRepository.add(car2);
        carRepository.add(car3);
        carRepository.add(car4);
        carRepository.add(car5);

        Car[] actual = carRepository.searchByColor("white").getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByPrice() {
        CarRepository carRepository = new CarRepository();
        Car[] expected = new Car[1];
        expected[0] = car3;

        carRepository.add(car1);
        carRepository.add(car2);
        carRepository.add(car3);
        carRepository.add(car4);
        carRepository.add(car5);

        Car[] actual = carRepository.searchByPrice(700000).getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByManufactureYear() {
        CarRepository carRepository = new CarRepository();
        Car[] expected = new Car[2];
        expected[0] = car2;
        expected[1] = car4;

        carRepository.add(car1);
        carRepository.add(car2);
        carRepository.add(car3);
        carRepository.add(car4);
        carRepository.add(car5);

        Car[] actual = carRepository.searchByManufactureYear(2013).getAll();
        assertArrayEquals(expected, actual);
    }
}