package com.voting.dto.response;

import com.voting.model.Person;
import com.voting.model.PlayPackage;
import lombok.Data;

import java.io.Serializable;

@Data
public class GetVoteResponseDTO implements Serializable {

    private int voteId;

    private Person person;

    private PlayPackage playPackage;

    @Override
    public String toString() {
        return "{ " +
                "voteId : " + voteId +
                ", Email : " + person.getEmail() +
                ", Play Package Strategy : " + playPackage.getStrategy() +
                '}';
    }
}
