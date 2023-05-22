package com.voting.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class CreatePersonResponseDTO implements Serializable {

    private int personId;
    private String email;
}
