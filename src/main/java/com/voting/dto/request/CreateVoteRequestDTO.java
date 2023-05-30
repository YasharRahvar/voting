package com.voting.dto.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class CreateVoteRequestDTO implements Serializable {

    private int personId;

    private int playPackageId;
}
