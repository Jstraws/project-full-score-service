package com.straus.fullscore.service;

import com.straus.fullscore.model.InstClassification;

import java.util.List;

public interface InstClassificationService {
    /**
     * Method to fetch all of the instrument classifications
     *
     * @return The list of instrument classifications
     */
    List<InstClassification> fetchAllClassifications();
}
