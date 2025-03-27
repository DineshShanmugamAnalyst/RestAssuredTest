package com.pojo;


// Functional Interface
interface SampleLamdaExpresions {
    void sayHello();
}

class B {
    public static void main(String[] args) {
        // Using Lambda Expression
        SampleLamdaExpresions g = () -> System.out.println("Hello from Lambda Expression!");

        g.sayHello();
    }
}

