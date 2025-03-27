package com.test;

import com.inputpojo.AddNewPet;
import com.inputpojo.TagOne;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;

public class PetDataProvider {

    @DataProvider(name = "petCredentials")
    public static Object[][] petData() {

        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("https://example.com/dog1.jpg");
        photoUrls.add("https://example.com/dog2.jpg");

        ArrayList<TagOne> tagList = new ArrayList<>();
        tagList.add(TagOne.builder().id(1).name("Pradeep").build());
        tagList.add(TagOne.builder().id(2).name("Ajith").build());

        return new Object[][]{{AddNewPet.builder().id(5).name("tommy").photoUrls(photoUrls).tags(tagList).build()}};

    }
}
