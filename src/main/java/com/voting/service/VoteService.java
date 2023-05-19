package com.voting.service;

import com.voting.dto.request.CreateVoteRequestDTO;
import com.voting.dto.response.CreateVoteResponseDTO;
import com.voting.dto.response.GetVoteResponseDTO;

public interface VoteService {

    CreateVoteResponseDTO createVote(CreateVoteRequestDTO createVoteRequestDTO);

    GetVoteResponseDTO getVote(int id);
}
