package com.straus.fullscore.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "inst_classification")
@Entity
@Getter
@Setter
public class InstClassification {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLASSIFICATION_ID_SEQ_GEN")
    @SequenceGenerator(name = "CLASSIFICATION_ID_SEQ_GEN", sequenceName = "CLASSIFICATION_ID_SEQ", allocationSize = 1)
    @Column(name = "classification_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "sort_order", nullable = false)
    private Long sortOrder;

}
