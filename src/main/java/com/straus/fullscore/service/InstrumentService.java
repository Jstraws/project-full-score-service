package com.straus.fullscore.service;

import com.straus.fullscore.model.Instrument;

import java.util.List;

public interface InstrumentService {
    Instrument getInstrumentById(Long id);

    Instrument saveInstrument(Instrument instrument);

    List<Instrument> getAllInstruments();
}
