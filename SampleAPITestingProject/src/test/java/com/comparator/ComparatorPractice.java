package com.comparator;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorPractice {

    public static void main(String[] args) {
        List<EmployeeClass> employees = Arrays.asList(
                new EmployeeClass(101, "Alice", 50000),
                new EmployeeClass(102, "Bob", 60000),
                new EmployeeClass(103, "Charlie", 55000),
                new EmployeeClass(104, "David", 45000)
        );

        List<EmployeeClass> sortedEmployees = employees.stream()
                .sorted((e1, e2) -> Double.compare(e1.salary, e2.salary))
                .collect(Collectors.toList());

        for (EmployeeClass e : sortedEmployees) {
            System.out.println(e);
        }

//
    }

    @Test
    public void comparePractice() {
        List<EmployeeClass> employees = Arrays.asList(
                new EmployeeClass(101, "Alice", 50000),
                new EmployeeClass(102, "Bob", 60000),
                new EmployeeClass(103, "Charlie", 55000),
                new EmployeeClass(104, "David", 45000)
        );

        Comparator<EmployeeClass> employeeComparator = (e1, e2) -> Double.compare(e1.salary, e2.salary);

        List<EmployeeClass> sortedEmployees = employees.stream()
                .sorted(employeeComparator)
                .collect(Collectors.toList());

        sortedEmployees.forEach(e ->
                System.out.println("Employee{id=" + e.id + ", name='" + e.name + "', salary=" + e.salary + "}")
        );
    }


    @Test
    public void comparingPractice() {
        List<EmployeeClass> employees = Arrays.asList(
                new EmployeeClass(101, "Alice", 50000),
                new EmployeeClass(102, "Bob", 60000),
                new EmployeeClass(103, "Charlie", 55000),
                new EmployeeClass(104, "David", 45000)
        );

        Comparator<EmployeeClass> employeeComparator = Comparator.comparing(e -> e.name);
        List<EmployeeClass> sortedEmployees = employees.stream()
                .sorted(employeeComparator)
                .collect(Collectors.toList());

        sortedEmployees.forEach(e ->
                System.out.println("Employee{id=" + e.id + ", name='" + e.name + "', salary=" + e.salary + "}")
        );
    }


    @Test
    public void compareToPractice() {
        List<EmployeeClass> employees = Arrays.asList(
                new EmployeeClass(101, "Alice", 50000),
                new EmployeeClass(102, "Bob", 60000),
                new EmployeeClass(103, "Charlie", 55000),
                new EmployeeClass(104, "David", 45000)
        );

        List<EmployeeClass> sortedEmployees = employees.stream()
                .sorted(Comparator.comparing(e -> e.salary)) // ✅ No need for naturalOrder()
                .collect(Collectors.toList());


        sortedEmployees.forEach(e ->
                System.out.println("Employee{id=" + e.id + ", name='" + e.name + "', salary=" + e.salary + "}")
        );
    }


    @Test
    public void naturalOrderPractice() {
        List<EmployeeClass> employees = Arrays.asList(
                new EmployeeClass(101, "Alice", 50000),
                new EmployeeClass(102, "Bob", 60000),
                new EmployeeClass(103, "Charlie", 55000),
                new EmployeeClass(104, "David", 45000)
        );

        // Sorting employee names using naturalOrder()
        List<String> sortedNames = employees.stream()
                .map(e -> e.name) // Extract names
                .sorted(Comparator.naturalOrder()) // Sort using natural order
                .collect(Collectors.toList());

        System.out.println("Sorted Employee Names (Natural Order): " + sortedNames);
    }


    @Test
    public void compareTooPractice() {
        List<EmployeeClass> employees = Arrays.asList(
                new EmployeeClass(101, "Alice", 50000),
                new EmployeeClass(102, "Bob", 60000),
                new EmployeeClass(103, "Charlie", 55000),
                new EmployeeClass(104, "David", 45000)
        );

        Comparator<EmployeeClass> nameComparator = (e1, e2) -> e1.name.compareTo(e2.name);

        employees.stream()
                .sorted(nameComparator)
                .collect(Collectors.toList()).forEach(System.out::println);
    }


}






