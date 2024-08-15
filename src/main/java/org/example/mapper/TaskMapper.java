package org.example.mapper;

import org.example.dto.PerformerDto;
import org.example.dto.TaskDto;
import org.example.model.Performer;
import org.example.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "header", source = "entity.header")
    @Mapping(target = "description", source = "entity.description")
    @Mapping(target = "authorDto", source = "entity.author")
    @Mapping(target = "performerDto", source = "entity.performer")
    @Mapping(target = "status", source = "entity.status")
    @Mapping(target = "priority", source = "entity.priority")
    TaskDto toDto(Task entity);

    @Mapping(target = "id", source = "dto.id")
    @Mapping(target = "header", source = "dto.header")
    @Mapping(target = "description", source = "dto.description")
    @Mapping(target = "author", source = "dto.authorDto")
    @Mapping(target = "performer", source = "dto.performerDto")
    @Mapping(target = "status", source = "dto.status")
    @Mapping(target = "priority", source = "dto.priority")
    Task toEntity(TaskDto dto);

    default List<TaskDto> toDtos(List<Task> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    default Optional<TaskDto> toOptionalDto(Optional<Task> entity) {
        return entity.map(this::toDto);
    }

}
