package com.test;

import com.inputpojo.AddNewPet;
import com.inputpojo.TagOne;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class PracticeGroups {


    @Test(description = "Add new pet"
            , groups = "addNewPetGroup",
            dataProvider = "petCredentials",
            dataProviderClass = PetDataProvider.class)

    public void addNewPet(AddNewPet pet) {

        Response response = RestAssured
                .given()
                //    .baseUri("https://petstore3.swagger.io/api/v3")
                .contentType("application/json")
                .body(pet)
                .post("/pet");
        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.statusCode(), 200, "Add new Pet failed");
    }

    @Test(description = "Find Pet By Id",
            dependsOnGroups = "addNewPetGroup",
            alwaysRun = false
    )
    public void findPet() throws InterruptedException {

        Thread.sleep(5000);

        Response response = RestAssured.given()
                //  .baseUri("https://petstore3.swagger.io/api/v3")
                .contentType("application/json")
                .get("/pet/5");

        System.out.println(response.asPrettyString());
        System.out.println("Response Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.getBody().asString());
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testPet3() {
        System.out.println("Executing testPet3...");
        Assert.fail("Failing test intentionally to check retry mechanism");
    }

}
