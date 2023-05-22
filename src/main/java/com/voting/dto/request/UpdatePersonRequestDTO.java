package com.voting.dto.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class UpdatePersonRequestDTO implements Serializable {

    private String email;
}
