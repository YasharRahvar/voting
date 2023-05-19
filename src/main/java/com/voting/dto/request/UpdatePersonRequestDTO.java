package com.voting.dto.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class UpdatePersonRequestDTO implements Serializable {
    private static final long serialVersionUID = 7156526077883281623L;

    private String email;
}
