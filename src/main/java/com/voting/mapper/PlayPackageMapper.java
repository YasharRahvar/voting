package com.voting.mapper;

import com.voting.dto.request.CreatePlayPackageRequestDTO;
import com.voting.dto.response.CreatePlayPackageResponseDTO;
import com.voting.dto.response.GetPlayPackageResponseDTO;
import com.voting.dto.response.UpdatePlayPackageResponseDTO;
import com.voting.model.PlayPackage;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PlayPackageMapper {

    private ModelMapper mapper;

    public PlayPackageMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public PlayPackage createPlayPackageRequestDTOtoPlayPackage(CreatePlayPackageRequestDTO createPlayPackageRequestDTO) {
        PlayPackage playPackage = mapper.map(createPlayPackageRequestDTO, PlayPackage.class);
        return playPackage;
    }

    public CreatePlayPackageResponseDTO playPackageToPlayPackageResponseDTO(PlayPackage playPackage) {
        CreatePlayPackageResponseDTO createPlayPackageResponseDTO = mapper.map(playPackage, CreatePlayPackageResponseDTO.class);
        return createPlayPackageResponseDTO;
    }

    public GetPlayPackageResponseDTO PlayPackageToGetPlayPackageResponseDTO(PlayPackage playPackage) {
        GetPlayPackageResponseDTO getPlayPackageResponseDTO = mapper.map(playPackage, GetPlayPackageResponseDTO.class);
        return getPlayPackageResponseDTO;
    }

    public UpdatePlayPackageResponseDTO playPackageToUpdatePlayPackageResponseDTO(PlayPackage playPackage) {
        UpdatePlayPackageResponseDTO updatePlayPackageResponseDTO = mapper.map(playPackage, UpdatePlayPackageResponseDTO.class);
        return updatePlayPackageResponseDTO;
    }
}

