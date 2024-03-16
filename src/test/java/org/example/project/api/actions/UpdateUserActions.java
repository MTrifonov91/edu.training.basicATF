package org.example.project.api.actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.example.project.api.dtos.responses.EmployeeUpdateResponse;
import org.example.project.configurations.api_specifications.EndPoint;
import org.example.project.configurations.scenario_context.Context;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;

public class UpdateUserActions extends Context {

    @And("A user update request is sent to endpoint: {endPoint}")
    public void sendUserUpdateRequest(EndPoint endPoint) {
        Context.response = given()
                .body(Context.dto)
                .put(endPoint.getValue())
                .then().log().all()
                .extract().response();
    }

    @Then("Response contains updatedAt timestamp equal to current time")
    public void responseContainsUpdatedAtTimestampEqualToCurrentTime() {
        DateTimeFormatter currentTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        DateTimeFormatter responseTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        LocalDateTime currentTime = LocalDateTime.now(ZoneOffset.UTC);
        EmployeeUpdateResponse response = Context.response.as(EmployeeUpdateResponse.class);
        LocalDateTime parsedResponseTime = LocalDateTime.parse(response.getUpdatedAt(), responseTimeFormatter);

        Assertions.assertEquals(currentTime.format(currentTimeFormatter), parsedResponseTime.format(currentTimeFormatter));
    }
}
