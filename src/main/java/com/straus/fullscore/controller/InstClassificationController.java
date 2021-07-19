package com.straus.fullscore.controller;

import com.straus.fullscore.model.InstClassification;
import com.straus.fullscore.service.InstClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/classification")
public class InstClassificationController {
    private final InstClassificationService instClassificationService;

    @Autowired
    public InstClassificationController(InstClassificationService instClassificationService) {
        this.instClassificationService = instClassificationService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstClassification>> fetchAllInstClassification() {
        return new ResponseEntity<>(this.instClassificationService.fetchAllClassifications(), HttpStatus.OK);
    }
}
