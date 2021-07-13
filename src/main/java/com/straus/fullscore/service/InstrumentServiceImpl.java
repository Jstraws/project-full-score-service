package com.straus.fullscore.service;

import com.straus.fullscore.model.Instrument;
import com.straus.fullscore.repo.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrumentServiceImpl implements InstrumentService {
    private final InstrumentRepository instrumentRepo;

    @Autowired
    public InstrumentServiceImpl(InstrumentRepository instrumentRepo) {
        this.instrumentRepo = instrumentRepo;
    }

    @Override
    public Instrument getInstrumentById(Long id) {
        return instrumentRepo.findById(id).orElse(null);
    }

    @Override
    public Instrument saveInstrument(Instrument instrument) {
        return instrumentRepo.save(instrument);
    }

    @Override
    public List<Instrument> getAllInstruments() {
        return instrumentRepo.findAll(Sort.by("sortOrder"));
    }
}
