package com.voting.dto.response;

import com.voting.model.Person;
import com.voting.model.PlayPackage;
import lombok.Data;

@Data
public class CreateVoteResponseDTO {

    private int voteId;

    private Person person;

    private PlayPackage playPackage;

}
