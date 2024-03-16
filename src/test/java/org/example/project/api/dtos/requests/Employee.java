package org.example.project.api.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.project.api.dtos.DTO;

@Data
@AllArgsConstructor
public class Employee implements DTO {
    private String name;
    private String job;
}
