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

    /**
     * Method to find all scores created by a specific user
     *
     * @param uuid The uuid of the user to filter by
     * @return The list of scores belonging to that user
     */
    List<Score> findScoresByUser(String uuid);

    /**
     * Method to delete a score by its id
     *
     * @param id The id of the score to delete
     */
    void deleteScoreById(Long id);
}
