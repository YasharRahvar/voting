package com.voting.controller;

import com.voting.dto.request.CreateVoteRequestDTO;
import com.voting.dto.response.CreateVoteResponseDTO;
import com.voting.dto.response.GetVoteResponseDTO;
import com.voting.model.Vote;
import com.voting.service.VoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoteController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VoteController.class);

    private VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping(value = "vote")
    @ResponseBody
    public ResponseEntity<CreateVoteResponseDTO> createVote(@RequestBody CreateVoteRequestDTO createVoteRequestDTO) {
        return new ResponseEntity<>(voteService.createVote(createVoteRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping(value = "/vote/{id}")
    @ResponseBody
    public ResponseEntity<GetVoteResponseDTO> getVote(@PathVariable int id) {
        return new ResponseEntity<>(voteService.getVote(id), HttpStatus.OK);
    }

    @GetMapping(value = "/votes")
    @ResponseBody
    public ResponseEntity<List<GetVoteResponseDTO>> getVotes() {
        return new ResponseEntity<>(voteService.getVotes(), HttpStatus.OK);
    }

    @GetMapping(value = "/voteCounts")
    public String getMessage() {

        StringBuilder builder = new StringBuilder();
        List<GetVoteResponseDTO> votes = voteService.getVotes();

        for (int i=0; i<=votes.size()-1; i++) {
            builder.append(votes.get(i).toString());
            builder.append("\n");
            builder.append("\t");
        }
/*        for (GetVoteResponseDTO vote: votes){
            builder.append(vote.toString());
        }*/
       return builder.toString();

    }
}
