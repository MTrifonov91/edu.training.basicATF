package org.example.project.api.dtos.responses.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Support {
    private String url;
    private String text;
}
