package com.comparator;

public class EmployeeClass {


    int id;
    String name;
    double salary;

    // Constructor
    public EmployeeClass(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + "}";
    }

    public double getSalary() {
        return salary;
    }

}
