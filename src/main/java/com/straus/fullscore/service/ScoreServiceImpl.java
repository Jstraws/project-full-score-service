package com.straus.fullscore.service;

import com.straus.fullscore.model.Person;
import com.straus.fullscore.model.Score;
import com.straus.fullscore.repo.PersonRepository;
import com.straus.fullscore.repo.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreServiceImpl implements ScoreService {
    private final ScoreRepository scoreRepository;
    private final PersonRepository personRepository;

    @Autowired
    public ScoreServiceImpl(ScoreRepository scoreRepository, PersonRepository personRepository) {
        this.scoreRepository = scoreRepository;
        this.personRepository = personRepository;
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
        // Check if composer already exists to prevent duplicates
        Optional<Person> composer = personRepository.findByFullName(score.getComposer().getFirstName(), score.getComposer().getLastName());
        composer.ifPresent(score::setComposer);

        // Same for arranger
        if (score.getArranger() != null) {
            Optional<Person> arranger = personRepository.findByFullName(score.getArranger().getFirstName(), score.getArranger().getLastName());
            arranger.ifPresent(score::setArranger);
        }

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

    /**
     * Method to delete a score by its id
     *
     * @param id The id of the score to delete
     */
    @Override
    public void deleteScoreById(Long id) {
        scoreRepository.deleteById(id);
    }
}
