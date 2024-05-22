package org.example.project.configurations.api_specifications;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

import static org.example.project.configurations.api_specifications.EndPoint.BASE_URL;
import static org.example.project.configurations.api_specifications.EndPoint.GET_USER;

public class ApiSpecifications {
    public static RequestSpecification requestSpec(EndPoint url) {
        return new RequestSpecBuilder()
                .setBaseUri(url.getValue())
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification responseSpec(int statusCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .build();
    }

    public static void installSpecification(RequestSpecification request, ResponseSpecification response) {
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }
}
