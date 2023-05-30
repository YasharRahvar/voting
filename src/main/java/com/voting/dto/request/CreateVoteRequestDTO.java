package com.voting.dto.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class CreateVoteRequestDTO implements Serializable {

    private int id;

    private int playPackageId;
}
