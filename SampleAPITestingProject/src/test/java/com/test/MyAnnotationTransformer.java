package com.test;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MyAnnotationTransformer implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

        if (testMethod.getName().equals("findPet")) {
            annotation.setEnabled(false);
        }

        if (testMethod.getName().equals("addNewPet")) {
            annotation.setInvocationCount(3);
        }
    }
}
