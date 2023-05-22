package com.voting.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class GetPersonResponseDTO implements Serializable {

    private int personId;
    private String email;

    @Override
    public String toString() {
        return
                "email: " + email;

    }
}
