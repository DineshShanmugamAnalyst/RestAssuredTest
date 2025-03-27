
package com.pojo;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Car {
    private String make;
    private String model;
    public int price;

    // Constructor
    public Car(String make, String model, int price) {
        this.make = make;
        this.model = model;
        this.price = price;
    }

    // Getter method for price
    public double getPrice() {
        return price;
    }
}
