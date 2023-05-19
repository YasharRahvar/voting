package com.voting.controller;

import com.voting.dto.request.CreatePlayPackageRequestDTO;
import com.voting.dto.response.CreatePlayPackageResponseDTO;
import com.voting.dto.response.GetPlayPackageResponseDTO;
import com.voting.service.PlayPackageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayPackageController {

    private PlayPackageService playPackageService;

    public PlayPackageController(PlayPackageService playPackageService) {
        this.playPackageService = playPackageService;
    }

    @PostMapping(value = "playPackage")
    @ResponseBody
    public ResponseEntity<CreatePlayPackageResponseDTO> createPlayPackage(@RequestBody CreatePlayPackageRequestDTO createPlayPackageRequestDTO) {
        return new ResponseEntity<>(playPackageService.createPlayPackage(createPlayPackageRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping(value = "/playPackage/{id}")
    @ResponseBody
    public ResponseEntity<GetPlayPackageResponseDTO> getPerson(@PathVariable int id) {
        return new ResponseEntity<>(playPackageService.getPlayPackage(id), HttpStatus.OK);
    }
}
