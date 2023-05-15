package com.voting.service;

import com.voting.dto.request.CreatePersonRequestDTO;
import com.voting.dto.response.CreatePersonResponseDTO;

public interface PersonService {

    CreatePersonResponseDTO CreatePerson(CreatePersonRequestDTO createPersonRequestDTO);
}
