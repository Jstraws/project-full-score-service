package com.straus.fullscore.service;

import com.straus.fullscore.model.Score;
import com.straus.fullscore.repo.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
    private ScoreRepository scoreRepository;

    @Autowired
    public ScoreServiceImpl(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    /**
     * Method to fetch all scores
     *
     * @return The list of all scores
     */
    @Override
    public List<Score> getAllScores() {
        return this.scoreRepository.findAll(Sort.by("title"));
    }

    /**
     * Method to save/update a score object
     *
     * @param score The score to update
     * @return The updated score
     */
    @Override
    public Score updateScore(Score score) {
        return this.scoreRepository.save(score);
    }
}
