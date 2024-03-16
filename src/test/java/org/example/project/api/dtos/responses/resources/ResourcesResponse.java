package org.example.project.api.dtos.responses.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourcesResponse {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<Datum> data;
    private Support support;
//
//    public ResourcesResponse(Map<String, String> params) {
//        this.page = Integer.parseInt(params.get("page"));
//        this.per_page = Integer.parseInt(params.get("per_page"));
//        this.total = Integer.parseInt(params.get("total"));
//        this.total_pages = Integer.parseInt(params.get("total_pages"));
//        this.data = List.of(new Datum(Integer.parseInt(params.get("id")),
//                params.get("name"),
//                Integer.parseInt(params.get("year")),
//                params.get("color"),
//                params.get("pantone_value")));
//        this.support = new Support(params.get("Support"), params.get("text"));
//    }

    public void addData(Datum datum) {
        data.add(datum);
    }
}
