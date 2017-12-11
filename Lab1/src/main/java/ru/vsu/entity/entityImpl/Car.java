package ru.vsu.entity.entityImpl;

import org.joda.time.LocalDate;

public class Car {
    private static int tempId = 1; //TODO: почитать про uuid и uid и мб переделать на них
    private int id;
    private String color;
    private LocalDate carDateManufacture;//TODO: сделать только год
    private int price;
    private String model;

    public Car(String model, int price, String color, LocalDate carDateManufacture) {
        this.id = tempId;
        tempId++;
        this.model = model;
        this.price = price;
        this.color = color;
        this.carDateManufacture = carDateManufacture;
    }

    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public LocalDate getCarDateManufacture() {
        return carDateManufacture;
    }

    public int getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return Car.class.getSimpleName() +
                " id=" + id +
                ", color='" + color + '\'' +
                ", carDateManufacture=" + carDateManufacture +
                ", price=" + price +
                ", model='" + model + '\'' +
                '}';
    }
}
