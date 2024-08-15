package org.example.mapper;

import org.example.dto.AuthorDto;
import org.example.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "personDto", source = "entity.person")
    @Mapping(target = "taskDtoList", source = "entity.taskList")
    AuthorDto toDto(Author entity);

    @Mapping(target = "id", source = "dto.id")
    @Mapping(target = "person", source = "dto.personDto")
    @Mapping(target = "taskList", source = "dto.taskDtoList")
    Author toEntity(AuthorDto dto);

    default List<AuthorDto> toDtos(List<Author> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    default Optional<AuthorDto> toOptionalDto(Optional<Author> entity) {
        return entity.map(this::toDto);
    }

}