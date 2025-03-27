package com.test;

import org.testng.IExecutionListener;

public class MyExecutionListener implements IExecutionListener {

    @Override
    public void onExecutionStart() {
        System.out.println("TestNG Suite Execution Started!");
    }

    @Override
    public void onExecutionFinish() {
        System.out.println("TestNG Suite Execution Finished");
    }
}
