package org.example.dto;

import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data public class TaskDto {

    @NotNull
    private long id;

    @NotEmpty
    private String header;

    @NotEmpty
    private String description;

    @NotNull
    private AuthorDto authorDto;

    @NotNull
    private PerformerDto performerDto;

    @NotEmpty
    @Size(min = 1, max = 20)
    private String status;

    @NotEmpty
    @Size(min = 1, max = 20)
    private String priority;

}
