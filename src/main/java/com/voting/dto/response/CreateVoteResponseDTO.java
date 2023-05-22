package com.voting.dto.response;

import com.voting.model.Person;
import com.voting.model.PlayPackage;
import lombok.Data;

import java.io.Serializable;

@Data
public class CreateVoteResponseDTO implements Serializable {

    private int voteId;

    private Person person;

    private PlayPackage playPackage;

}
