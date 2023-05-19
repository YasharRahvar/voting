package com.voting.mapper;

import com.voting.dto.request.CreatePersonRequestDTO;
import com.voting.dto.response.CreatePersonResponseDTO;
import com.voting.dto.response.GetPersonResponseDTO;
import com.voting.dto.response.UpdatePersonResponseDTO;
import com.voting.model.Person;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    private ModelMapper mapper;

    public PersonMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }


    public Person createPersonRequestDTOtoPerson(CreatePersonRequestDTO createPersonRequestDTO) {
        Person person = mapper.map(createPersonRequestDTO, Person.class);
        return person;
    }

    public CreatePersonResponseDTO personToPersonResponseDTO(Person person) {
        CreatePersonResponseDTO createPersonResponseDTO = mapper.map(person, CreatePersonResponseDTO.class);
        return createPersonResponseDTO;
    }

    public GetPersonResponseDTO personToGetPersonResponseDTO(Person person) {
        GetPersonResponseDTO getPersonResponseDTO = mapper.map(person, GetPersonResponseDTO.class);
        return getPersonResponseDTO;
    }

    public UpdatePersonResponseDTO personToUpdatePersonResponseDTO(Person person) {
        UpdatePersonResponseDTO updatePersonResponseDTO = mapper.map(person, UpdatePersonResponseDTO.class);
        return updatePersonResponseDTO;
    }
}
