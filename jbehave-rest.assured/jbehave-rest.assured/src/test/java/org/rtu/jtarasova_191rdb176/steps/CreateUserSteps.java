package org.rtu.jtarasova_191rdb176.steps;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hamcrest.Matchers;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.rtu.jtarasova_191rdb176.dto.ErrorItem;
import org.rtu.jtarasova_191rdb176.dto.User;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateUserSteps {

    private static final String API_URL = "https://gorest.co.in";
    private static final String ACCESS_TOKEN = "c759ab45473dcfd5bdac438dc8de960fcd3b24ecbe9c967323e27a662dff613d";

    private Response response;
    private User userResponse;
    private RequestSpecification requestSpecification;
    private List<ErrorItem> errorResponse = List.of();

    @Given("Request body: $body")
    public void givenRequestBody(String body) {
        requestSpecification = given()
                .log().all(true)
                .baseUri(API_URL)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .body(body);
    }

    @When("User performs \"$method\" request to \"$path\"")
    public void whenUserPerformsRequestTo(String method, String path) {
        response = requestSpecification.when()
                .request(method, path);
        System.out.println("Response is:");
        response.body().prettyPrint();
    }

    @Then("response status is $status")
    public void thenResponseContainsStatus(int status) {
        response.then().statusCode(status);
    }

    @Then("response body is not null")
    public void thenResponseBodyIsNotNull() {
        response.then().body("$", Matchers.notNullValue());
    }

    @Then("response body contains user id")
    public void thenResponseBodyContainsUserId() {
        response.then().body("id", Matchers.notNullValue());
    }

    @Then("response body name is $name")
    public void thenResponseBodyNameIs(String name) {
        response.then().body("name", Matchers.equalTo(name));
    }

    @Then("response body email is $email")
    public void thenResponseBodyEmailIs(String email) {
        response.then().body("email", Matchers.equalTo(email));
    }

    @Then("response body gender is $gender")
    public void thenResponseBodyGenderIs(String gender) {
        response.then().body("gender", Matchers.equalTo(gender));
    }

    @Then("response body contains error field: $field")
    public void thenResponseBodyContainsErrorField(String field) {
        response.then().body("[0].field", Matchers.equalTo(field));
    }

    @Then("response body contains error message: $message")
    public void thenResponseBodyContainsErrorMessage(String message) {
        response.then().body("[0].message", Matchers.equalTo(message));
    }
}
