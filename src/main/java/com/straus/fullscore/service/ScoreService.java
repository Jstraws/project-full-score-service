package com.straus.fullscore.service;

import com.straus.fullscore.model.Score;

import java.util.List;

public interface ScoreService {
    /**
     * Method to fetch all scores
     *
     * @return The list of all scores
     */
    List<Score> getAllScores();

    /**
     * Method to save/update a score object
     *
     * @param score The score to update
     * @return The updated score
     */
    Score updateScore(Score score);
}
