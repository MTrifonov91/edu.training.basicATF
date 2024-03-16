package org.example.project.api.dtos.responses;

import lombok.Data;
import org.example.project.api.dtos.DTO;

@Data
public class EmployeeCreationResponse implements DTO {
    private String name;
    private String job;
    private String id;
    private String createdAt;
}
