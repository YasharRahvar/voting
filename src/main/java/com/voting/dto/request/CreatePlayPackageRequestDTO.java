package com.voting.dto.request;

import com.voting.model.Strategy;
import lombok.Data;

import java.io.Serializable;


@Data
public class CreatePlayPackageRequestDTO implements Serializable {

    private Strategy strategy;
}
