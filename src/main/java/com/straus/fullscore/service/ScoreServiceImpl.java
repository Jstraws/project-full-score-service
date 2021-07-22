package com.straus.fullscore.service;

import com.straus.fullscore.model.Score;
import com.straus.fullscore.repo.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
    private final ScoreRepository scoreRepository;

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
        return scoreRepository.findAll(Sort.by("title"));
    }

    /**
     * Method to save/update a score object
     *
     * @param score The score to update
     * @return The updated score
     */
    @Override
    public Score updateScore(Score score) {
        return scoreRepository.save(score);
    }

    /**
     * Method to find all scores created by a specific user
     *
     * @param uuid The uuid of the user to filter by
     * @return The list of scores belonging to that user
     */
    @Override
    public List<Score> findScoresByUser(String uuid) {
        return scoreRepository.findByAppUser_UuidEquals(uuid);
    }
}
