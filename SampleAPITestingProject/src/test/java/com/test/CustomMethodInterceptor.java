package com.test;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;

public class CustomMethodInterceptor implements IMethodInterceptor {

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        List<IMethodInstance> filteredMethods = new ArrayList<>();

        for (IMethodInstance m : methods) {

            if (m.getMethod().getMethodName().contains("Pet")) {
                filteredMethods.add(m);
            }
        }
        return filteredMethods;
    }
}


//        for (IMethodInstance method : methods) {
//            // Example: Execute only methods that belong to "addNewPetGroup"
//            if (method.getMethod().getGroups().length > 0) {  // Prevents unnecessary looping over an empty array.
//                for (String group : method.getMethod().getGroups()) {
//                    if (group.equalsIgnoreCase("addNewPetGroup")) {
//                        filteredMethods.add(method);
//                    }
//                }
//            }
//        }


