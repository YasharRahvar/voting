package com.voting.service;

import com.voting.dto.request.CreateVoteRequestDTO;
import com.voting.dto.response.CreateVoteResponseDTO;
import com.voting.dto.response.GetVoteResponseDTO;

import java.util.List;

public interface VoteService {

    CreateVoteResponseDTO createVote(CreateVoteRequestDTO createVoteRequestDTO);

    GetVoteResponseDTO getVote(int id);

    List<GetVoteResponseDTO> getVotes();
}
