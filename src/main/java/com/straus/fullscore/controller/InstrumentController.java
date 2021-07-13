package com.straus.fullscore.controller;

import com.straus.fullscore.model.Instrument;
import com.straus.fullscore.service.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instrument")
public class InstrumentController {
    private final InstrumentService instrumentService;

    @Autowired
    public InstrumentController(InstrumentService instrumentService) {
        this.instrumentService = instrumentService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Instrument>> getAllInstruments() {
        return new ResponseEntity<>(instrumentService.getAllInstruments(), HttpStatus.OK);
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Instrument> saveInstrument(@RequestBody Instrument instrument) {
        Instrument tempInstrument = instrumentService.saveInstrument(instrument);
        if (tempInstrument != null) {
            return new ResponseEntity<>(tempInstrument, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Instrument> getInstrumentById(@PathVariable Long id) {
        Instrument tempInstrument = instrumentService.getInstrumentById(id);
        if (tempInstrument != null) {
            return new ResponseEntity<>(tempInstrument, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
