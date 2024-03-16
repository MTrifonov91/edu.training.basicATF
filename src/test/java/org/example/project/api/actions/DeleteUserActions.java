package org.example.project.api.actions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.example.project.configurations.api_specifications.EndPoint;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class DeleteUserActions {

    Response response;

    @When("A user deletion request is sent to endpoint: {endPoint}")
    public void sendDeletionRequestToEndpoint(EndPoint endpoint) {
        response = given()
                .when()
                .delete(endpoint.getValue())
                .then().log().all()
                .extract().response();
    }

    @Then("Response body is empty")
    public void validateResponseBodyIsEmpty() {
        assertTrue(response.body().asString().isEmpty());
    }
}
