package com.kalanso.gevent.Model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String details;

    @ManyToOne
    @JoinColumn(name = "evenement_id")
    private Evenement evenement;

    // Getters et Setters
}

