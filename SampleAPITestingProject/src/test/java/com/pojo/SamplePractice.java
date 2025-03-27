package com.pojo;

// Define an interface
interface SamplePractice {
    void sayHello();
}

class A {
    public static void main(String[] args) {
        // Using Anonymous Inner Class
        SamplePractice g = new SamplePractice() {  // Correct: Implementing the interface
            @Override
            public void sayHello() {
                System.out.println("Hello from Anonymous Inner Class!");
            }
        };

        g.sayHello();
    }
}
