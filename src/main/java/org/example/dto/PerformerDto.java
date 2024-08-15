package org.example.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class PerformerDto {

    @NotNull
    private long id;

    @NotNull
    PersonDto personDto;

    @NotNull
    List<TaskDto> taskDtoList;
}
