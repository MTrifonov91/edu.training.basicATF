package org.example.project.api.dtos.responses;

import lombok.Data;
import org.example.project.api.dtos.DTO;

@Data
public class RegistrationResponse implements DTO {

    private int id;
    private String token;
}
