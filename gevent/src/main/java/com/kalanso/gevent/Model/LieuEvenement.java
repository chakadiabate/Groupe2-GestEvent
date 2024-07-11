package com.kalanso.gevent.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class LieuEvenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String adresse;

    @OneToMany(mappedBy = "lieu")
    private Set<AvoirLieu> avoirLieux = new HashSet<>();

    // Getters et Setters
}

