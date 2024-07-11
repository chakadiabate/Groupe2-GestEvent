package com.kalanso.gevent.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Gestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "evenement_id")
    private Evenement evenement;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    // Getters et Setters
}

