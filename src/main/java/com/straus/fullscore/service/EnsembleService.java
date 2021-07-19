package com.straus.fullscore.service;

import com.straus.fullscore.model.Ensemble;

import java.util.List;

public interface EnsembleService {
    /**
     * Method to fetch a list of all ensembles
     *
     * @return The list of all ensembles
     */
    List<Ensemble> fetchAllEnsembles();
}
