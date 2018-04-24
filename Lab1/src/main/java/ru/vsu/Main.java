package ru.vsu;

import org.joda.time.LocalDate;
import ru.vsu.entity.entityImpl.Car;
import ru.vsu.entity.entityImpl.Person;
import ru.vsu.repository.repositoryImpl.CarRepository;
import ru.vsu.repository.repositoryImpl.PersonRepository;
import ru.vsu.util.Observer;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PersonRepository personRepository = new PersonRepository();
        CarRepository carRepository = new CarRepository();
        //personRepository.debug();
        //Creating new objects Person
        Person person1 = new Person("1", "1", "1");
        Person person2 = new Person("2", "2", "2");
        Person person3 = new Person("3", "3", "3");
        Person person4 = new Person("4", "4", "2");
        Person person5 = new Person("5", "5", "5", new LocalDate(1993, 7, 27));

        Car car1 = new Car("BMW", 2000000, "black", 2007);
        Car car2 = new Car("Audi", 1300000, "blue", 2013);
        Car car3 = new Car("Lada", 700000, "red", 2015);
        Car car4 = new Car("Mitsubishi", 1000000, "white", 2013);
        Car car5 = new Car("Lexus", 6000000, "white", 2009);

        ArrayList<Car> writeCars = new ArrayList<>();
        ArrayList<Car> readCars = new ArrayList<>();
        writeCars.add(car1);
        writeCars.add(car2);
        writeCars.add(car3);
        writeCars.add(car4);
        writeCars.add(car5);

        Observer observer = new Observer();

        try {
            observer.runXmlWriter(writeCars);
            readCars = observer.runXmlParser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Car car : readCars) {
            carRepository.add(car);
        }
//        carRepository.add(car1);
//        carRepository.add(car5);
//        carRepository.add(car3);
//        carRepository.add(car4);
//        carRepository.add(car2);


    }
}
