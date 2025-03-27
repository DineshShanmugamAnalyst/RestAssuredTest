package com.pojo;

import java.util.List;

public class MockData {

    public static List<Car> getCars() {
        return List.of(
                new Car("Toyota", "Camry", 25000),
                new Car("Honda", "Civic", 22000),
                new Car("Ford", "Mustang", 28000),
                new Car("Tesla", "Model 3", 40000)
        );
    }
}



