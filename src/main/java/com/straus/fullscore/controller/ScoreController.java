package com.straus.fullscore.controller;

import com.straus.fullscore.model.Score;
import com.straus.fullscore.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreController {
    private final ScoreService scoreService;

    @Autowired
    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Score>> fetchAllScores() {
        return new ResponseEntity<>(scoreService.getAllScores(), HttpStatus.OK);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Score> updateScore(@RequestBody Score score) {
        return new ResponseEntity<>(scoreService.updateScore(score), HttpStatus.OK);
    }

    @GetMapping(value = "/user/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Score>> fetchUserScores(@PathVariable String uuid) {
        return new ResponseEntity<>(scoreService.findScoresByUser(uuid), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteScore(@PathVariable Long id) {
        try {
            scoreService.deleteScoreById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
