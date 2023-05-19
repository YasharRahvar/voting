package com.voting.service;

import com.voting.dto.request.CreatePersonRequestDTO;
import com.voting.dto.request.UpdatePersonRequestDTO;
import com.voting.dto.response.CreatePersonResponseDTO;
import com.voting.dto.response.GetPersonResponseDTO;
import com.voting.dto.response.UpdatePersonResponseDTO;
import com.voting.exception.PersonNotFoundException;
import com.voting.mapper.PersonMapper;
import com.voting.model.Person;
import com.voting.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonServiceImpl.class);
    private PersonMapper personMapper;

    private PersonRepository personRepository;

    public PersonServiceImpl(PersonMapper personMapper, PersonRepository personRepository) {
        this.personMapper = personMapper;
        this.personRepository = personRepository;
    }

    @Override
    public CreatePersonResponseDTO createPerson(CreatePersonRequestDTO createPersonRequestDTO) {
        return personMapper.personToPersonResponseDTO(personRepository.save(personMapper.createPersonRequestDTOtoPerson(createPersonRequestDTO)));
    }

    @Override
    @Cacheable(cacheNames = "Persons", key = "#id")
    public GetPersonResponseDTO getPerson(int id) {
        LOGGER.info("Fetching from db");
        return personMapper.personToGetPersonResponseDTO(personRepository.findById(id).orElseThrow(()
                -> new PersonNotFoundException("Person with ID " + id + " Not Found")));
    }

    @Override
    @CachePut(cacheNames = "Persons", key = "#id")
    public UpdatePersonResponseDTO updatePerson(int id, UpdatePersonRequestDTO updatePersonRequestDTO) {
        Person person = personRepository.findById(id).orElseThrow(()-> new PersonNotFoundException("Person with ID " + id + " Not Found"));
        person.setEmail(updatePersonRequestDTO.getEmail());
        return personMapper.personToUpdatePersonResponseDTO(personRepository.save(person));
    }
}
