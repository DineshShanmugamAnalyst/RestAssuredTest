package com.test;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import io.restassured.RestAssured;

public class CustomSuiteListener implements ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        String suiteName = suite.getName();

        // Set Base URI based on the suite name
        if (suiteName.equalsIgnoreCase("Pet API Test Suite")) {
            RestAssured.baseURI = "https://petstore3.swagger.io/api/v3";
        } else {
            RestAssured.baseURI = "https://default.example.com/api";
        }

        System.out.println("Suite Started: " + suiteName);
        System.out.println("Base URI Set: " + RestAssured.baseURI);
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("Suite Finished: " + suite.getName());
    }
}
