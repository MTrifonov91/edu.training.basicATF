package org.example.project.api.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.project.api.dtos.DTO;

@Data
@AllArgsConstructor
public class Registration implements DTO {

    private String email;
    private String password;
}
