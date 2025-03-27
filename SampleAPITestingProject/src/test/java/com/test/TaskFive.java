package com.test;

public class TaskFive {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String name;
    public String department;

    public TaskFive(String name, String department) {
        this.name = name;
        this.department = department;
    }
}
