package com.voting.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class GetPersonResponseDTO implements Serializable {

    private static final long serialVersionUID = 7156526077883281623L;
    private int personId;
    private String email;
}
