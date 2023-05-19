package com.voting.service;

import com.voting.dto.request.CreateVoteRequestDTO;
import com.voting.dto.response.CreateVoteResponseDTO;
import com.voting.dto.response.GetVoteResponseDTO;
import com.voting.exception.VoteNotFoundException;
import com.voting.mapper.VoteMapper;
import com.voting.repository.VoteRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements VoteService {

    private VoteRepository voteRepository;
    private VoteMapper voteMapper;


    public VoteServiceImpl(VoteRepository voteRepository, VoteMapper voteMapper) {
        this.voteRepository = voteRepository;
        this.voteMapper = voteMapper;
    }

    @Override
    public CreateVoteResponseDTO createVote(CreateVoteRequestDTO createVoteRequestDTO) {
        return voteMapper.voteToVoteResponseDTO(voteRepository.save(voteMapper.createVoteRequestDTOtoVote(createVoteRequestDTO)));
    }

    @Override
    @Cacheable(cacheNames = "Votes", key = "#id")
    public GetVoteResponseDTO getVote(int id) {
        return voteMapper.voteToGetVoteResponseDTO(voteRepository.findById(id).orElseThrow(()
                -> new VoteNotFoundException("Vote with ID " + id + " Not Found")));
    }
}
