package ru.vsu.entity;

public class Client {
    private String operation;
    private double amount;
    private long time_in_seconds;


    public Client(String operation, double amount, long time_in_seconds) {
        this.operation = operation;
        this.amount = amount;
        this.time_in_seconds = time_in_seconds;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getTime_in_seconds() {
        return time_in_seconds;
    }

    public void setTime_in_seconds(long time_in_seconds) {
        this.time_in_seconds = time_in_seconds;
    }

    @Override
    public String toString() {
        return Client.class.getSimpleName() +
                " operation='" + operation + '\'' +
                ", amount=" + amount +
                ", time_in_seconds=" + time_in_seconds +
                '}';
    }
}
