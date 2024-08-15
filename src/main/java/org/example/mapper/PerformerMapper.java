package org.example.mapper;

import org.example.dto.PerformerDto;
import org.example.model.Performer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PerformerMapper {

    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "personDto", source = "entity.person")
    @Mapping(target = "taskDtoList", source = "entity.taskList")
    PerformerDto toDto(Performer entity);

    @Mapping(target = "id", source = "dto.id")
    @Mapping(target = "person", source = "dto.personDto")
    @Mapping(target = "taskList", source = "dto.taskDtoList")
    Performer toEntity(PerformerDto dto);

    default List<PerformerDto> toDtos(List<Performer> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    default Optional<PerformerDto> toOptionalDto(Optional<Performer> entity) {
        return entity.map(this::toDto);
    }

}