package org.example.project.api.dtos.responses.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Datum {
    private int id;
    private String name;
    private int year;
    private String color;
    private String pantone_value;

    public Datum(Map<String, String> params) {
        this.id = Integer.parseInt(params.get("id"));
        this.name = params.get("name");
        this.year = Integer.parseInt(params.get("year"));
        this.color = params.get("color");
        this.pantone_value = params.get("pantone_value");
    }
}
