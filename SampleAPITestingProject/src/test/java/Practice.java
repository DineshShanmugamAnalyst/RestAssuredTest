import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;

import static io.restassured.RestAssured.given;

public class Practice {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }

    @Test(priority = 2)
    public void testMethod1() {
        System.out.println("Test Method 1");
    }

    @Test(priority = 1)
    public void testMethod2() {
        System.out.println("Test Method 2");
    }

    @Test(enabled = false)
    public void testMethod3() {
        System.out.println("Test Method 3");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }

    @Test(description = "Retrieve the user details from the API.",
            invocationCount = 4,
            invocationTimeOut = 10000,
            threadPoolSize = 2)
    public void getUsers() {

        System.out.println("Thread ID: " + Thread.currentThread().getId());
        long startTime = System.currentTimeMillis();

        RestAssured.baseURI = "https://reqres.in/api";
        Response response = given()
                .when()
                .get("/users?page=2")
                .then()
                .statusCode(200)
                .extract()
                .response();

        long endTime = System.currentTimeMillis();
        long responseTime = endTime - startTime;

        System.out.println("API Response Time: " + responseTime + " ms");
        Assert.assertTrue(responseTime < 3000, "API took too long to respond!");
    }


    @Test(invocationCount = 3, timeOut = 3000)
    public void testAPIResponseTimeWithTimeOut() {
        long startTime = System.currentTimeMillis();

        RestAssured.baseURI = "https://reqres.in/api";
        Response response = given()
                .when()
                .get("/users?page=2")
                .then()
                .statusCode(200)
                .extract()
                .response();

        System.out.println("Response: " + response.asPrettyString());

        long endTime = System.currentTimeMillis();
        long responseTime = endTime - startTime;

        System.out.println("API Response Time: " + responseTime + " ms");
        Assert.assertTrue(responseTime < 1000, "API took too long to respond!");
    }
}



