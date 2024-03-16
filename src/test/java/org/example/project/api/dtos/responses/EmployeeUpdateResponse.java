package org.example.project.api.dtos.responses;

import lombok.Data;
import org.example.project.api.dtos.DTO;

@Data
public class EmployeeUpdateResponse implements DTO {
    private String name;
    private String job;
    private String updatedAt;
}
