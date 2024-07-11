package com.kalanso.gevent.Model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AvoirLieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "evenement_id")
    private Evenement evenement;

    @ManyToOne
    @JoinColumn(name = "lieu_id")
    private LieuEvenement lieu;

    // Getters et Setters
}

