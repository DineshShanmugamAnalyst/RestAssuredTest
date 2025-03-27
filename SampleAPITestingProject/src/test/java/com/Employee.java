package com;

import java.util.Arrays;
import java.util.List;

public class Employee {
    private String name;
    private int age;
    private double salary;
    private char gender;

    public Employee(String name, int age, double salary, char gender) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age + ", Salary: " + salary + ", Gender: " + gender);
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Ravi", 25, 50000, 'M');
        Employee e2 = new Employee("Priya", 30, 75000, 'F');
        Employee e3 = new Employee("Amit", 28, 60000, 'M');
        Employee e4 = new Employee("Sneha", 35, 90000, 'F');
        Employee e5 = new Employee("Rajesh", 40, 110000, 'M');
        Employee e6 = new Employee("Neha", 22, 45000, 'F');
        Employee e7 = new Employee("Vikram", 27, 65000, 'M');
        Employee e8 = new Employee("Kavya", 33, 80000, 'F');
        Employee e9 = new Employee("Suresh", 29, 70000, 'M');
        Employee e10 = new Employee("Ananya", 26, 55000, 'F');

        // who male and age less that 30 salary < 70000

        List<Employee> emp = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);
        double average = emp.stream().filter(e -> e.age < 30 && e.salary < 70000 && e.gender == 'M').mapToInt(e -> e.age).average().orElse(0);
        System.out.println(average);
    }



}










