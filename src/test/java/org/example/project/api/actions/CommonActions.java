package org.example.project.api.actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.example.project.configurations.api_specifications.ApiSpecifications;
import org.example.project.configurations.api_specifications.EndPoint;
import org.example.project.configurations.scenario_context.Context;

import static io.restassured.RestAssured.given;

public class CommonActions extends Context {

    @Given("Specifications are installed with expected response code {int}")
    public void specsAreInstalledWithCode(int code) {
        ApiSpecifications.installSpecification(ApiSpecifications.requestSpec(EndPoint.BASE_URL), ApiSpecifications.responseSpec(code));
    }

    @When("A GET request is sent to endpoint: {endPoint}")
    public void aGetRequestIsMadeTo(EndPoint endPoint) {
        Context.response = given()
                .when()
                .get(endPoint.getValue())
                .then().log().all()
                .extract().response();
    }
}
