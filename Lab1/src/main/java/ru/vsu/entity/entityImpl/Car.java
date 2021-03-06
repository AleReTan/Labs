package ru.vsu.entity.entityImpl;

public class Car {
    private static int tempId = 1;
    private int id;
    private String color;
    private int carDateManufacture;
    private int price;
    private String model;

    public Car() {
    }

    public Car(String model, int price, String color, int carDateManufacture) {
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

    public int getCarYearManufacture() {
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

    public void setCarDateManufacture(int carDateManufacture) {
        this.carDateManufacture = carDateManufacture;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setId(int id) {
        this.id = id;
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
