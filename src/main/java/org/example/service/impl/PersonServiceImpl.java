package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.PersonDto;
import org.example.dto.PersonPageDto;
import org.example.mapper.PersonMapper;
import org.example.model.Person;
import org.example.repository.PersonRepository;
import org.example.service.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    @Transactional(readOnly = true)
    public List<PersonDto> findAll() {
        return personMapper.toListDto(personRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PersonDto> getById(long id) {
        return personMapper.toOptionalDto(
                personRepository.findById(id));
    }

    @Override
    public PersonPageDto getPage(Pageable pageable) {
        Page<Person> currentPage = personRepository.findAll(pageable);
        return new PersonPageDto(personMapper.toListDto(currentPage.getContent()),
                currentPage.getNumber(),
                currentPage.getTotalPages(),
                currentPage.hasNext(),
                currentPage.hasPrevious());
    }

    @Override
    @Transactional
    public PersonDto save(@Valid PersonDto personDto) {
        long id = personDto.getId();
        Person person = personMapper.toEntity(personDto);
        return personMapper.toDto(personRepository.save(person));
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        log.info("Удаляется запись о пользователе с id: {}", id);
        personRepository.delete(personRepository.findById(id).orElseThrow());
    }
}
