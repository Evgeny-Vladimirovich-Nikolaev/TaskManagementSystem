package org.example.controller.rest;

import lombok.RequiredArgsConstructor;
import org.example.dto.ResultDto;
import org.example.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @DeleteMapping("/persons/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        personService.deleteById(id);
        return ResponseEntity.ok(new ResultDto());
    }

}

