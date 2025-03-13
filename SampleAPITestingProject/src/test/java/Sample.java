import com.pojo.Add_New_Pet;
import com.pojo.Add_New_Pet_Input_Pojo;
import com.pojo.Category;
import com.pojo.Tag;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class Sample {

    @Test
    public void testMethod() {
        System.out.println("Hello, TestNG!");
    }

    @Test
    public void testCreatePet() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        Category category = new Category(1, "Dogs");
        Tag tag = new Tag(1, "Bulldog");

        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("https://example.com/dog1.jpg");
        photoUrls.add("https://example.com/dog2.jpg");

        ArrayList<Tag> tags = new ArrayList<>(Arrays.asList(tag));

        //    Add_New_Pet_Input_Pojo pet = new Add_New_Pet_Input_Pojo(1, category, "doggie", photoUrls, tags, "available");

        Add_New_Pet p1 = Add_New_Pet.builder().id(1).name("tom").build();

        Response response = given()
                .contentType(ContentType.JSON)
                .body(p1)
                .when()
                .post("/pet")
                .then()
                .statusCode(200)
                .log().all()
                .extract()
                .response();

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("name"), "tom");
    }

    @Test
    public void getListUsers() {

        RestAssured.baseURI = "https://reqres.in/api";
        Response response = given()
                .queryParam("page", 2)
                .contentType(ContentType.JSON)
                .when()
                .get("/users")
                .then()
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemavalidation.json"))
                .statusCode(200)
                .log().all()
                .extract()
                .response();
        System.out.println("Response: " + response.asString());
    }
}
