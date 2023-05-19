package com.voting.service;

import com.voting.dto.request.CreateVoteRequestDTO;
import com.voting.dto.response.CreateVoteResponseDTO;
import com.voting.dto.response.GetVoteResponseDTO;
import com.voting.exception.VoteNotFoundException;
import com.voting.mapper.VoteMapper;
import com.voting.model.Vote;
import com.voting.repository.VoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VoteServiceImpl implements VoteService {
    private static final Logger LOGGER = LoggerFactory.getLogger(VoteServiceImpl.class);

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
    @Cacheable(cacheNames = "Vote", key = "#id")
    public GetVoteResponseDTO getVote(int id) {
        LOGGER.info("Fetching from db");
        return voteMapper.voteToGetVoteResponseDTO(voteRepository.findById(id).orElseThrow(()
                -> new VoteNotFoundException("Vote with ID " + id + " Not Found")));
    }

    @Override
    @Cacheable(cacheNames = "Votes")
    public List<GetVoteResponseDTO> getVotes() {
        LOGGER.info("Fetching from db");
        List<Vote> votes = voteRepository.findAll();
        return votes.stream().map(vote -> voteMapper.voteToGetVoteResponseDTO(vote)).collect(Collectors.toList());
    }
}
