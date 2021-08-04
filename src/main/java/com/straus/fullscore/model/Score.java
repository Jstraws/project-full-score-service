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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCORE_ID_SEQ_GEN")
    @SequenceGenerator(name = "SCORE_ID_SEQ_GEN", sequenceName = "SCORE_ID_SEQ", allocationSize = 1)
    @Column(name = "score_id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Enumerated
    @Column(name = "score_status", nullable = false)
    private ScoreStatus scoreStatus;

    @OrderBy("sortOrder")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "score_score_id")
    private List<Part> parts;

    @ManyToOne()
    @JoinColumn(name = "ensemble_ensemble_id")
    private Ensemble ensemble;

    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private AppUser appUser;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "composer_id")
    private Person composer;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "arranger_id")
    private Person arranger;

}
