package org.example.project.api.actions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.example.project.api.dtos.requests.Employee;
import org.example.project.api.dtos.responses.EmployeeCreationResponse;
import org.example.project.configurations.api_specifications.EndPoint;
import org.example.project.configurations.scenario_context.Context;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CreateUserActions extends Context {

    @When("An Employee with name {string} and job {string} is created")
    public void anEmployeeWithNameAndJobIsCreated(String employeeName, String jobTitle) {
        Context.dto = new Employee(employeeName, jobTitle);
    }

    @And("A user creation request is sent to endpoint: {endPoint}")
    public void aRequestToEndpointsMade(EndPoint endPoint) {

        Context.response = given()
                .body(Context.dto)
                .when()
                .post(endPoint.getValue())
                .then().log().all()
                .extract().response();
    }

    @Then("Response contains createdAt timestamp equal to current time")
    public void responseContainsCreatedAtTimestampEqualToCurrentTime() {
        EmployeeCreationResponse response = Context.response.as(EmployeeCreationResponse.class);
        DateTimeFormatter currentTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        DateTimeFormatter responseTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        LocalDateTime currentTime = LocalDateTime.now(ZoneOffset.UTC);
        LocalDateTime parsedResponseTime = LocalDateTime.parse(response.getCreatedAt(), responseTimeFormatter);

        Assertions.assertEquals(currentTime.format(currentTimeFormatter), parsedResponseTime.format(currentTimeFormatter));
    }

    @When("An Employee is created with the following data:")
    public void anEmployeeIsCreatedWithTheFollowingData(DataTable table) {
        Map<String, String> params = table.asMap();

        Context.dto = new Employee(params.get("name"), params.get("job"));
    }
}
