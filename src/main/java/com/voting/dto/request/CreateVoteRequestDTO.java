package com.voting.dto.request;

import lombok.Data;

@Data
public class CreateVoteRequestDTO {

    private int personId;

    private int playPackageId;
}
