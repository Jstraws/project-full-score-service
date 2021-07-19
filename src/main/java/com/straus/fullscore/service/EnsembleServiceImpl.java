package com.straus.fullscore.service;

import com.straus.fullscore.model.Ensemble;
import com.straus.fullscore.repo.EnsembleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnsembleServiceImpl implements EnsembleService {
    private final EnsembleRepository ensembleRepository;

    @Autowired
    public EnsembleServiceImpl(EnsembleRepository ensembleRepository) {
        this.ensembleRepository = ensembleRepository;
    }

    /**
     * Method to fetch a list of all ensembles
     *
     * @return The list of all ensembles
     */
    @Override
    public List<Ensemble> fetchAllEnsembles() {
        return this.ensembleRepository.findAll(Sort.by("name"));
    }
}
