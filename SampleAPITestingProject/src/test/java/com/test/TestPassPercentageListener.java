package com.test;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestPassPercentageListener implements ITestListener {

    @Override
    public void onFinish(ITestContext context) {
        int passedTests = context.getPassedTests().size();
        int failedTests = context.getFailedTests().size();
        int skippedTests = context.getSkippedTests().size();

        int totalTests = passedTests + failedTests + skippedTests;

        double passPercentage = (totalTests == 0) ? 0 : ((double) passedTests / totalTests) * 100;

        System.out.println("Test Execution Summary:");
        System.out.println("Passed Tests: " + passedTests);
        System.out.println("Failed Tests: " + failedTests);
        System.out.println("Skipped Tests: " + skippedTests);
        System.out.println("Pass Percentage: " + passPercentage + "%");
    }
}
