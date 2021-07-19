package com.straus.fullscore.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "score")
@Entity
@Getter
@Setter
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "score_id", nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "composer")
    private String composer;

    @Column(name = "arranger")
    private String arranger;

    @OrderBy("instrument.name")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "score_score_id")
    private List<Part> parts;

    @ManyToOne()
    @JoinColumn(name = "ensemble_ensemble_id")
    private Ensemble ensemble;

}
