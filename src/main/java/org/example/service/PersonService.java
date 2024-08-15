package org.example.service;

import org.example.dto.PersonPageDto;
import org.springframework.data.domain.Pageable;
import org.example.dto.PersonDto;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface PersonService {

    List<PersonDto> findAll();

    Optional<PersonDto> getById(long id);

    PersonPageDto getPage(Pageable pageable);

    PersonDto save(@Valid PersonDto personDto);

    void deleteById(long id);

}
