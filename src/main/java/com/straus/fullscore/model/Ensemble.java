package com.straus.fullscore.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "ensemble")
@Entity
@Getter
@Setter
public class Ensemble {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENSEMBLE_ID_SEQ_GEN")
    @SequenceGenerator(name = "ENSEMBLE_ID_SEQ_GEN", sequenceName = "ENSEMBLE_ID_SEQ", allocationSize = 1)
    @Column(name = "ensemble_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

}
