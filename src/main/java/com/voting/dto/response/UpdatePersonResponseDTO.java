package com.voting.dto.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class UpdatePersonResponseDTO implements Serializable {
    private static final long serialVersionUID = 7156526077883281623L;
    private int personId;
    private String email;
}
