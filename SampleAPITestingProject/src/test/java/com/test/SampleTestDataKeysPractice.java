package com.test;

import com.inputpojo.AddNewPet;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTestDataKeysPractice {

    @Test(description = "Add new pet",
            groups = "addNewPetGroup",
            dataProvider = "petCredentials",
            dataProviderClass = NewPetDataProvider.class)
    @TestDataKeys({"id", "name"})  // Only request 'id' and 'name' //passed as string values inside an array
    public void addNewPet(Integer id, String name) {

        AddNewPet petData = AddNewPet.builder().id(id).name(name).build();

        Response response = RestAssured
                .given()
                .baseUri("https://petstore3.swagger.io/api/v3")
                .contentType("application/json")
                .body(petData)
                .post("/pet");

        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(), 200, "Add new Pet failed");
    }
}
