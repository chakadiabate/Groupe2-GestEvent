package com.kalanso.gevent.Model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Posseder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "evenement_id")
    private Evenement evenement;

    @ManyToOne
    @JoinColumn(name = "type_ticket_id")
    private TypeTicket typeTicket;

    // Getters et Setters
}

