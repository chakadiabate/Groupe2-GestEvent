package com.kalanso.gevent.Model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private TypeEvenement type;

    @OneToMany(mappedBy = "evenement")
    private Set<Reservation> reservations = new HashSet<>();

    @OneToMany(mappedBy = "evenement")
    private Set<AvoirLieu> avoirLieux = new HashSet<>();

    @OneToMany(mappedBy = "evenement")
    private Set<Posseder> posseders = new HashSet<>();

    @OneToMany(mappedBy = "evenement")
    private Set<Gestion> gestions = new HashSet<>();

    // Getters et Setters
}

