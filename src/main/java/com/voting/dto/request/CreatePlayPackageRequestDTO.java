package com.voting.dto.request;

import com.voting.model.Strategy;
import lombok.Data;


@Data
public class CreatePlayPackageRequestDTO {

    private Strategy strategy;
}
