package com.straus.fullscore.service;

import com.straus.fullscore.model.InstClassification;
import com.straus.fullscore.repo.InstClassificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstClassificationServiceImpl implements InstClassificationService {
    private final InstClassificationRepository instClassificationRepository;

    @Autowired
    public InstClassificationServiceImpl(InstClassificationRepository instClassificationRepository) {
        this.instClassificationRepository = instClassificationRepository;
    }

    /**
     * Method to fetch all of the instrument classifications
     *
     * @return The list of instrument classifications
     */
    @Override
    public List<InstClassification> fetchAllClassifications() {
        return instClassificationRepository.findAll(Sort.by("name"));
    }
}
