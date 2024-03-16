package org.example.project.api.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.project.api.dtos.DTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements DTO {

    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}
