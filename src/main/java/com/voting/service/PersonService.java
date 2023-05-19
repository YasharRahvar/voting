package com.voting.service;

import com.voting.dto.request.CreatePersonRequestDTO;
import com.voting.dto.request.UpdatePersonRequestDTO;
import com.voting.dto.response.CreatePersonResponseDTO;
import com.voting.dto.response.GetPersonResponseDTO;
import com.voting.dto.response.UpdatePersonResponseDTO;

public interface PersonService {

    CreatePersonResponseDTO createPerson(CreatePersonRequestDTO createPersonRequestDTO);

    GetPersonResponseDTO getPerson(int id);

    UpdatePersonResponseDTO updatePerson(int id, UpdatePersonRequestDTO updatePersonRequestDTO);
}
