package org.example.project.api.actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.project.api.dtos.requests.Registration;
import org.example.project.api.dtos.responses.RegistrationResponse;
import org.example.project.configurations.api_specifications.EndPoint;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class RegisterUserActions {

    Registration registration;

    RegistrationResponse response;

    @When("A new Registration with email {string} and password {string} is created")
    public void newRegistration(String email, String password) {
        registration = new Registration(email, password);
    }

    @And("A registration request is send to endpoint: {endPoint}")
    public void sendRequest(EndPoint endPoint) {
        response = given()
                .body(registration)
                .when()
                .post(endPoint.getValue())
                .then().log().all()
                .extract().as(RegistrationResponse.class);
    }

    @Then("Response contains token: {string}")
    public void responseContainsToken(String token) {
        Assertions.assertEquals(token, response.getToken());
    }
}
