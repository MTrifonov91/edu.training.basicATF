package org.example.project.api.actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.example.project.api.dtos.DTO;
import org.example.project.api.dtos.requests.Employee;
import org.example.project.api.dtos.responses.EmployeeUpdateResponse;
import org.example.project.configurations.api_specifications.EndPoint;
import org.example.project.configurations.scenario_context.Context;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;
import static org.example.project.configurations.scenario_context.Context.ContextKeys;

public class UpdateUserActions {

    private static final Context context = Context.getInstance();

    @And("A user update request is sent to endpoint: {endPoint}")
    public void sendUserUpdateRequest(EndPoint endPoint) {
        Employee employee = context.getContext(ContextKeys.DTO, Employee.class);

        Response response = given()
                .body(employee)
                .put(endPoint.getValue())
                .then().log().all()
                .extract().response();

        context.setContext(ContextKeys.RESPONSE, response);
    }

    @Then("Response contains updatedAt timestamp equal to current time")
    public void responseContainsUpdatedAtTimestampEqualToCurrentTime() {
        DateTimeFormatter currentTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        DateTimeFormatter responseTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        LocalDateTime currentTime = LocalDateTime.now(ZoneOffset.UTC);
        EmployeeUpdateResponse response = context.getContext(ContextKeys.RESPONSE, Response.class).as(EmployeeUpdateResponse.class);
        LocalDateTime parsedResponseTime = LocalDateTime.parse(response.getUpdatedAt(), responseTimeFormatter);

        Assertions.assertEquals(currentTime.format(currentTimeFormatter), parsedResponseTime.format(currentTimeFormatter));
    }
}
