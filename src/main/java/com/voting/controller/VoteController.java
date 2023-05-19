package com.voting.controller;

import com.voting.dto.request.CreateVoteRequestDTO;
import com.voting.dto.response.CreateVoteResponseDTO;
import com.voting.dto.response.GetVoteResponseDTO;
import com.voting.service.VoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VoteController {


    private VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping(value = "vote")
    @ResponseBody
    public ResponseEntity<CreateVoteResponseDTO> createPerson(@RequestBody CreateVoteRequestDTO createVoteRequestDTO) {
        return new ResponseEntity<>(voteService.createVote(createVoteRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping(value = "/vote/{id}")
    @ResponseBody
    public ResponseEntity<GetVoteResponseDTO> getPerson(@PathVariable int id) {
        return new ResponseEntity<>(voteService.getVote(id), HttpStatus.OK);
    }
}
