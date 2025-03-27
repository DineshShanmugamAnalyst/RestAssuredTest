package com.test;

public class TaskTwo {
    public String names;
    public double salary;

    public String getNames() {
        return names;
    }

    public double getSalary() {
        return salary;
    }

    public TaskTwo(String names, double salary) {
        this.names = names;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return names + " - " + salary;
    }
}
