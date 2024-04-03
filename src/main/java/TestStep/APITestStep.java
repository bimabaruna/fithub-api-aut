package TestStep;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;

import java.io.File;


public class APITestStep extends BaseStep {

    private static final String BASE_URL = "https://reqres.in/";
    private static Response response;

    @Given("user create user")
    public void userCreateUser() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        File expectedSchema = new File(System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "main"
                + File.separator + "java"
                + File.separator + "Resource"
                + File.separator +"CreateUserSchema.json");

        request.header("authority", "reqres.in")
                .header("Content-Type", "application/json" )
                .header("Accept", "application/json");

        response = request.body("{\n" +
                "    \"name\": \"George\",\n" +
                "    \"job\": \"leader\"\n" +
                "}").log().all().post("api/users");

        String actualResponse = response.getBody().asString();
        System.out.println(actualResponse);
        System.out.println(response.getStatusCode());
        Assert.assertEquals(201, response.getStatusCode());
        MatcherAssert.assertThat(actualResponse, JsonSchemaValidator.matchesJsonSchema(expectedSchema));

    }

    @And("user get userid")
    public void userGetUserid() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        File expectedSchema = new File(System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "main"
                + File.separator + "java"
                + File.separator + "Resource"
                + File.separator +"GetUserIdSchema.json");


        request.header("authority", "reqres.in")
                .header("Content-Type", "application/json" )
                .header("Accept", "application/json");

        response = request.log().all().get("api/users/");
        String actualResponse = response.getBody().asString();
        System.out.println(actualResponse);
        System.out.println(response.getStatusCode());
        Assert.assertEquals(200, response.getStatusCode());
        MatcherAssert.assertThat(actualResponse, JsonSchemaValidator.matchesJsonSchema(expectedSchema));

    }

    @And("user update username")
    public void userUpdateUsernameTo() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        File expectedSchema = new File(System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "main"
                + File.separator + "java"
                + File.separator + "Resource"
                + File.separator
                +"UpdateUserSchema.json");


        request.header("authority", "reqres.in")
                .header("Content-Type", "application/json" )
                .header("Accept", "application/json");

        response = request.body("{\n" +
                "    \"name\": \"Testing\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}").log().all().put("api/users/");

        String actualResponse = response.getBody().asString();
        System.out.println(actualResponse);
        System.out.println(response.getStatusCode());
        Assert.assertEquals(200, response.getStatusCode());
        MatcherAssert.assertThat(actualResponse, JsonSchemaValidator.matchesJsonSchema(expectedSchema));

    }
}
