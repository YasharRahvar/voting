package com.voting.mapper;

import com.voting.dto.request.CreateVoteRequestDTO;
import com.voting.dto.response.CreateVoteResponseDTO;
import com.voting.dto.response.GetVoteResponseDTO;
import com.voting.model.Vote;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class VoteMapper {

    private ModelMapper mapper;

    public VoteMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }


    public Vote createVoteRequestDTOtoVote(CreateVoteRequestDTO createVoteRequestDTO) {
        Vote vote = mapper.map(createVoteRequestDTO, Vote.class);
        return vote;
    }

    public CreateVoteResponseDTO voteToVoteResponseDTO(Vote vote) {
        CreateVoteResponseDTO createVoteResponseDTO = mapper.map(vote, CreateVoteResponseDTO.class);
        return createVoteResponseDTO;
    }

    public GetVoteResponseDTO voteToGetVoteResponseDTO(Vote vote) {
        GetVoteResponseDTO getVoteResponseDTO = mapper.map(vote, GetVoteResponseDTO.class);
        return getVoteResponseDTO;
    }

}
