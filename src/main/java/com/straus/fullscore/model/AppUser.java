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
    @Column(name = "uuid", nullable = false)
    private String uuid;
}
