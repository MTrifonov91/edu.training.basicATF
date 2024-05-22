package org.example.project.api.actions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.example.project.api.dtos.DTO;
import org.example.project.api.dtos.requests.Employee;
import org.example.project.api.dtos.requests.User;
import org.example.project.api.dtos.responses.EmployeeCreationResponse;
import org.example.project.configurations.api_specifications.EndPoint;
import org.example.project.configurations.scenario_context.Context;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.example.project.configurations.scenario_context.Context.ContextKeys;

@Slf4j
public class CreateUserActions {

    private static final Context context = Context.getInstance();

    @When("An Employee with name {string} and job {string} is created")
    public void anEmployeeWithNameAndJobIsCreated(String employeeName, String jobTitle) {
        context.setContext(ContextKeys.DTO, new Employee(employeeName, jobTitle));
    }

    @And("A user creation request is sent to endpoint: {endPoint}")
    public void aRequestToEndpointsMade(EndPoint endPoint) {
        Employee employee = context.getContext(ContextKeys.DTO, Employee.class);

        Response response = given()
                .body(employee)
                .when()
                .post(endPoint.getValue())
                .then().log().all()
                .extract().response();

        context.setContext(ContextKeys.RESPONSE, response);
    }

    @Then("Response contains createdAt timestamp within range of current time + {int} seconds")
    public void responseContainsCreatedAtTimestampEqualToCurrentTime(int seconds) {
        EmployeeCreationResponse response = context.getContext(ContextKeys.RESPONSE, Response.class).as(EmployeeCreationResponse.class);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        LocalDateTime currentTime = LocalDateTime.now(ZoneOffset.UTC);
        LocalDateTime creationTime = LocalDateTime.parse(response.getCreatedAt(), formatter);

        Assertions.assertTrue(creationTime.isBefore(currentTime.plusSeconds(seconds)));
//        log.info(STR."CreatedAt time was within the admissible range: \{currentTime} to \{creationTime.plusSeconds(seconds)}");
    }

    @When("An Employee is created with the following data:")
    public void anEmployeeIsCreatedWithTheFollowingData(DataTable table) {
        Map<String, String> params = table.asMap();

        context.setContext(ContextKeys.DTO, new Employee(params.get("name"), params.get("job")));
    }
}
