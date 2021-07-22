package com.straus.fullscore.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "app_user")
@Entity
@Getter
@Setter
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APPUSER_ID_GEN")
    @SequenceGenerator(name = "APPUSER_ID_GEN", sequenceName = "APPUSER_ID_SEQ", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "uuid", unique = true)
    private String uuid;

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "app_user_id")
    private List<Score> scores;

}
