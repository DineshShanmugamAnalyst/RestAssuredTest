package com.test;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class MyInvokedMethodListener implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("Starting Test: " + method.getTestMethod().getMethodName());
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        String testName = method.getTestMethod().getMethodName();
        long executionTime = testResult.getEndMillis() - testResult.getStartMillis();

        if (testResult.getStatus() == ITestResult.SUCCESS) {
            System.out.println(" PASSED 1: " + testName + " (Execution Time: " + executionTime + "ms)");
        } else if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println(" FAILED: " + testName);

        } else if (testResult.getStatus() == ITestResult.SKIP) {
            System.out.println(" SKIPPED: " + testName);
        }
    }
}
