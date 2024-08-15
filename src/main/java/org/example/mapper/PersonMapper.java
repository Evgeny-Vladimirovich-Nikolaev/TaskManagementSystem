package org.example.mapper;

import org.example.dto.PersonDto;
import org.example.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "login", source = "entity.login")
    PersonDto toDto(Person entity);

    @Mapping(target = "id", source = "dto.id")
    @Mapping(target = "login", source = "dto.login")
    Person toEntity(PersonDto dto);

    default List<PersonDto> toListDto(List<Person> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    default Optional<PersonDto> toOptionalDto(Optional<Person> entity) {
        return entity.map(this::toDto);
    }

}
