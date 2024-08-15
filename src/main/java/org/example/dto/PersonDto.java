package org.example.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class PersonDto {

    @NotNull
    private long id;

    @NotNull
    @Size(min = 1, max = 60)
    private String login;

}
