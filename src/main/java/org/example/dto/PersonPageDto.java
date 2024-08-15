package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PersonPageDto{

    private List<PersonDto> data;

    private int currentPage;

    private int totalPage;

    private boolean hasNext;

    private boolean hasPrevious;

}
