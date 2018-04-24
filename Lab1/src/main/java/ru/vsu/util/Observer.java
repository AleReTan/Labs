package ru.vsu.util;

import ru.vsu.entity.entityImpl.Car;

import java.text.ParseException;
import java.util.*;

public class Observer {
    public ArrayList<Car> runXmlParser() throws ParseException {
        XmlParser read = new XmlParser();
        List<Car> readCars = read.parse("/Users/alexresh/IdeaProjects/Labs/Lab1/src/main/resources/carsNew.xml");
        for (Car car : readCars) {
            System.out.println(car);
        }
        return (ArrayList<Car>) readCars;
    }

    public void runXmlWriter(ArrayList<Car> arrayList) throws Exception {
        XmlWriter write = new XmlWriter();
        write.saveCars("/Users/alexresh/IdeaProjects/Labs/Lab1/src/main/resources/carsNew.xml", arrayList);

    }
}