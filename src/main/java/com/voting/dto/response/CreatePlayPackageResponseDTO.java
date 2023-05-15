package com.voting.dto.response;

import com.voting.model.Strategy;
import lombok.Data;

@Data
public class CreatePlayPackageResponseDTO {

    private int playPackageId;

    private Strategy strategy;
}
