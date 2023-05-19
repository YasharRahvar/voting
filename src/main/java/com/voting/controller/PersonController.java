package com.voting.controller;

import com.voting.dto.request.CreatePersonRequestDTO;
import com.voting.dto.request.UpdatePersonRequestDTO;
import com.voting.dto.response.CreatePersonResponseDTO;
import com.voting.dto.response.GetPersonResponseDTO;
import com.voting.dto.response.UpdatePersonResponseDTO;
import com.voting.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    @Value("${my.env}")
    private String message;

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(value = "person")
    @ResponseBody
    public ResponseEntity<CreatePersonResponseDTO> createPerson(@RequestBody CreatePersonRequestDTO createPersonRequestDTO) {
        return new ResponseEntity<>(personService.createPerson(createPersonRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping(value = "/person/{id}")
    @ResponseBody
    public ResponseEntity<GetPersonResponseDTO> getPerson(@PathVariable int id) {
        return new ResponseEntity<>(personService.getPerson(id), HttpStatus.OK);
    }

    @PutMapping(value = "/person/{id}")
    public ResponseEntity<UpdatePersonResponseDTO> updatePerson(@PathVariable int id, @RequestBody UpdatePersonRequestDTO updatePersonRequestDTO) {
        return new ResponseEntity<>(personService.updatePerson(id, updatePersonRequestDTO), HttpStatus.OK);
    }

    @GetMapping(value = "message")
    public String getMessage() {
        LOGGER.info("message from controller");

        return message;
    }

}