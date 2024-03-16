package org.example.project.hooks;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.DefaultDataTableCellTransformer;
import io.cucumber.java.DefaultDataTableEntryTransformer;
import io.cucumber.java.DefaultParameterTransformer;
import io.cucumber.java.ParameterType;
import org.example.project.api.dtos.responses.resources.Datum;
import org.example.project.api.dtos.responses.resources.ResourcesResponse;
import org.example.project.configurations.api_specifications.EndPoint;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class CustomParameters {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @DefaultParameterTransformer
    @DefaultDataTableEntryTransformer
    @DefaultDataTableCellTransformer
    public Object transformer(Object fromValue, Type toValueType) {
        return objectMapper.convertValue(fromValue, objectMapper.constructType(toValueType));
    }

    @ParameterType(".*")
    public EndPoint endPoint(String endpoint) {
        return EndPoint.valueOf(endpoint);
    }

    @DataTableType
    public Datum datumTransformer(Map<String, String> row) {

        return new Datum(
                Integer.parseInt(row.get("id")),
                row.get("name"),
                Integer.parseInt(row.get("year")),
                row.get("color"),
                row.get("pantone_value")
        );
    }

    @DataTableType
    public ResourcesResponse resourcesResponseTransformer(DataTable table) {

        ResourcesResponse resourcesResponse = new ResourcesResponse();

//        resourcesResponse.setPage(table.);

        return resourcesResponse;
    }
}
