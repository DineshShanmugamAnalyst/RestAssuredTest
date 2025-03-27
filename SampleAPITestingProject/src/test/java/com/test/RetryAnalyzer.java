package com.test;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 3;  // Maximum retry attempts

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            System.out.println("Retrying test: " + result.getName() + " | Attempt " + retryCount + "/" + maxRetryCount);
            return true;
        }
        System.out.println("Test failed after " + maxRetryCount + " retries: " + result.getName());
        return false;
    }
}
