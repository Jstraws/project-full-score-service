package com.straus.fullscore.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Table(name = "instrument")
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Instrument {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INSTRUMENT_ID_SEQ_GEN")
    @SequenceGenerator(name = "INSTRUMENT_ID_SEQ_GEN", sequenceName = "INSTRUMENT_ID_SEQ", allocationSize = 1)
    @Column(name = "instrument_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToOne()
    @JoinColumn(name = "inst_classification_classification_id")
    private InstClassification instClassification;

}
