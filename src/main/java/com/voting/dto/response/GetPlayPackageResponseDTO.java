package com.voting.dto.response;

import com.voting.model.Strategy;
import lombok.Data;

import java.io.Serializable;

@Data
public class GetPlayPackageResponseDTO implements Serializable {
    private int PlayPackageId;
    private Strategy strategy;
}
