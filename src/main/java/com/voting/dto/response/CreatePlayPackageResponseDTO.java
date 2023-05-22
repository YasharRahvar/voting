package com.voting.dto.response;

import com.voting.model.Strategy;
import lombok.Data;

import java.io.Serializable;


@Data
public class CreatePlayPackageResponseDTO implements Serializable {

    private int playPackageId;

    private Strategy strategy;
}
