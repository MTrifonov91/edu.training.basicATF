package org.example.project.configurations.scenario_context;

import io.restassured.response.Response;
import org.example.project.api.dtos.DTO;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Context {

    protected static WebDriver webDriver;

    protected static Response response;
    protected static DTO dto;

    protected static List<DTO> dtos;

    Map<String, String> objects = new HashMap<>();


}
