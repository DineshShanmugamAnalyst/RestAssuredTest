import com.inputpojo.AddNewPet;
import com.inputpojo.TagOne;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class PracticeGroup {

    @BeforeMethod(onlyForGroups = "addNewPetGroup")
    public void setUpAddPet() {
        System.out.println("Setup for 'addNewPetGroup' is completed");
    }



    @Test(description = "Add new pet", groups = "addNewPetGroup")
    public void addNewPet() {
        System.out.println("Executing addNewPet()...");

        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("https://example.com/dog1.jpg");
        photoUrls.add("https://example.com/dog2.jpg");

        ArrayList<TagOne> tagList = new ArrayList<>();
        tagList.add(TagOne.builder().id(1).name("Pradeep").build());
        tagList.add(TagOne.builder().id(2).name("Ajith").build());

        AddNewPet addNewPet = AddNewPet.builder()
                .name("tommy")
                .id(1)
                .photoUrls(photoUrls)
                .tags(tagList)
                .build();

        Response response = RestAssured
                .given()
                .baseUri("https://petstore3.swagger.io/api/v3")
                .contentType("application/json")
                .body(addNewPet)
                .post("/pet");

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.statusCode(), 200, "Add new Pet failed");
    }

    @Test(description = "Find Pet By Id",
            dependsOnGroups = "addNewPetGroup",
            alwaysRun = true, // Ensures it runs even if addNewPet() fails
            groups = "findPetGroup"
    )
    public void findPet() throws InterruptedException {
        System.out.println("Executing findPet()...");

        Thread.sleep(5000);

        Response response = RestAssured.given()
                .baseUri("https://petstore3.swagger.io/api/v3")
                .contentType("application/json")
                .get("/pet/1");

        System.out.println(response.asPrettyString());
        System.out.println("Response Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        Assert.assertEquals(response.statusCode(), 200, "Find Pet By ID failed");
    }
}
