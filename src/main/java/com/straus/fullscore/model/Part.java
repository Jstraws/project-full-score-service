package com.straus.fullscore.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Table(name = "part")
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PART_ID_SEQ_GEN")
    @SequenceGenerator(name = "PART_ID_SEQ_GEN", sequenceName = "PART_ID_SEQ", allocationSize = 1)
    @Column(name = "part_id", nullable = false)
    private Long id;

    @Column(name = "file_url", nullable = false)
    private String fileUrl;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "instrument_id", nullable = false)
    private Instrument instrument;

    @Column(name = "sort_order", nullable = false)
    private Integer sortOrder;

}
