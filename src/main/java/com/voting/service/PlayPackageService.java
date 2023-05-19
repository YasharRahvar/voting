package com.voting.service;

import com.voting.dto.request.CreatePlayPackageRequestDTO;
import com.voting.dto.response.CreatePlayPackageResponseDTO;
import com.voting.dto.response.GetPlayPackageResponseDTO;

public interface PlayPackageService {

    CreatePlayPackageResponseDTO createPlayPackage(CreatePlayPackageRequestDTO createPlayPackageRequestDTO);

    GetPlayPackageResponseDTO getPlayPackage(int id);
}
