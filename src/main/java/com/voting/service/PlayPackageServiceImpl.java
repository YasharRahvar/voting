package com.voting.service;

import com.voting.dto.request.CreatePlayPackageRequestDTO;
import com.voting.dto.response.CreatePlayPackageResponseDTO;
import com.voting.dto.response.GetPlayPackageResponseDTO;
import com.voting.exception.PlayPackageNotFoundException;
import com.voting.mapper.PlayPackageMapper;
import com.voting.repository.PlayPackageRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayPackageServiceImpl implements PlayPackageService {

    private PlayPackageMapper playPackageMapper;

    private PlayPackageRepository playPackageRepository;

    public PlayPackageServiceImpl(PlayPackageMapper playPackageMapper, PlayPackageRepository playPackageRepository) {
        this.playPackageMapper = playPackageMapper;
        this.playPackageRepository = playPackageRepository;
    }

    @Override
    public CreatePlayPackageResponseDTO createPlayPackage(CreatePlayPackageRequestDTO createPlayPackageRequestDTO) {
        return playPackageMapper.playPackageToPlayPackageResponseDTO(playPackageRepository.save(playPackageMapper.createPlayPackageRequestDTOtoPlayPackage(createPlayPackageRequestDTO)));
    }

    @Override
    public GetPlayPackageResponseDTO getPlayPackage(int id) {
        return playPackageMapper.PlayPackageToGetPlayPackageResponseDTO(playPackageRepository.findById(id).orElseThrow(()
                -> new PlayPackageNotFoundException("Play Package with ID " + id + " Not Found")));
    }


}
