package org.example.project.api.actions;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.example.project.api.dtos.responses.resources.Datum;
import org.example.project.api.dtos.responses.resources.ResourcesResponse;
import org.example.project.configurations.api_specifications.EndPoint;
import org.example.project.configurations.scenario_context.Context;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

@Slf4j
public class ResourcesValidationActions extends Context {



    @Then("Response matches the following data:")
    public void responseMatchesData(List<Datum> data) {
        log.info(data.toString());
//        ResourcesResponse expectedResponse = new ResourcesResponse(params);
//        ResourcesResponse actualResponse = Context.response.as(ResourcesResponse.class);
//
//        Assertions.assertEquals(expectedResponse, actualResponse);
    }

    @Then("Response for object {string} matches the following data:")
    public void responseMatchesData(String objectType, List<Map<String, String>> formParams) {
//        List<Map<String, String>> formParams = table.asMaps();
        List<Datum> expectedDatumList = formParams.stream()
                .map(Datum::new)
                .toList();

        List<Datum> actualDatumsList = Context.response.body().jsonPath().getList("data", Datum.class);

        Assertions.assertIterableEquals(expectedDatumList, actualDatumsList);
    }

    @When("A get resources request is sent to endpoint: {endPoint}")
    public void aGetResourcesRequestIsSent(EndPoint endPoint) {
        Context.response = given()
                .when()
                .get(endPoint.getValue())
                .then().log().all()
                .extract().response();
    }

    @Then("Response matches data from the following JSON file: {string}")
    public void responseMatchesDatFromTheFollowingJSON(String jsonPath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ResourcesResponse expectedResponse = objectMapper.readValue(
                new File(jsonPath),
                ResourcesResponse.class
        );

        ResourcesResponse actualResponse = Context.response.as(ResourcesResponse.class);

        Assertions.assertEquals(expectedResponse, actualResponse);
    }

    @Then("Response matches the following dataaaa:")
    public void responseMatchesTheFollowingDataaaa(ResourcesResponse expectedResponse) {
        ResourcesResponse actualResponse = Context.response.as(ResourcesResponse.class);
        Assertions.assertEquals(expectedResponse, actualResponse);
    }
}
