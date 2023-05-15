package com.voting.controller;

import com.voting.dto.request.CreatePersonRequestDTO;
import com.voting.dto.response.CreatePersonResponseDTO;
import com.voting.service.PersonService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    @Value("${my.env}")
    private String message;

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(value = "person")
    @ResponseBody
    public ResponseEntity<CreatePersonResponseDTO> createPerson(@RequestBody CreatePersonRequestDTO createPersonRequestDTO) {
        return new ResponseEntity<>(personService.CreatePerson(createPersonRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping(value = "message")
    public String getMessage() {

        return message;
    }
}
