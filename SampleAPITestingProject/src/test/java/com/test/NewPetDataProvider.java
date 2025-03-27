package com.test;


import com.inputpojo.AddNewPet;
import com.inputpojo.TagOne;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class NewPetDataProvider {

    @DataProvider(name = "petCredentials")
    public static Object[][] petData(Method method) {

        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("https://example.com/dog1.jpg");
        photoUrls.add("https://example.com/dog2.jpg");

        ArrayList<TagOne> tagList = new ArrayList<>();
        tagList.add(TagOne.builder().id(1).name("Pradeep").build());
        tagList.add(TagOne.builder().id(2).name("Ajith").build());

        AddNewPet pet = AddNewPet.builder().id(5).name("tommy").photoUrls(photoUrls).tags(tagList).build();



        // Check if @TestDataKeys annotation is present on the test method
        if (method.isAnnotationPresent(TestDataKeys.class)) {
            TestDataKeys testDataKeys = method.getAnnotation(TestDataKeys.class);
            String[] keys = testDataKeys.value();

            if (keys.length == 2 && keys[0].equals("id") && keys[1].equals("name")) {
                return new Object[][]{{pet.getId(), pet.getName()}};
            }
        }

        // Default: Return the full object
        return new Object[][]{{pet}};
    }
}

