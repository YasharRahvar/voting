package com.voting.service;

import com.voting.dto.request.CreatePersonRequestDTO;
import com.voting.dto.response.CreatePersonResponseDTO;
import com.voting.mapper.PersonMapper;
import com.voting.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonMapper personMapper;

    private PersonRepository personRepository;

    public PersonServiceImpl(PersonMapper personMapper, PersonRepository personRepository) {
        this.personMapper = personMapper;
        this.personRepository = personRepository;
    }

    @Override
    public CreatePersonResponseDTO CreatePerson(CreatePersonRequestDTO createPersonRequestDTO) {
        return personMapper.personToPersonResponseDTO(personRepository.save(personMapper.createPersonRequestDTOtoPerson(createPersonRequestDTO)));
    }
}
