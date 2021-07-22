package com.straus.fullscore.controller;

import com.straus.fullscore.model.Ensemble;
import com.straus.fullscore.service.EnsembleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ensemble")
public class EnsembleController {
    private final EnsembleService ensembleService;

    @Autowired
    public EnsembleController(EnsembleService ensembleService) {
        this.ensembleService = ensembleService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ensemble>> fetchAllEnsembles() {
        return new ResponseEntity<>(ensembleService.fetchAllEnsembles(), HttpStatus.OK);
    }
}
