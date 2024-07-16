package com.kalanso.event.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "statut_id")
    private StatutReservation statut;

    @ManyToOne
    @JoinColumn(name = "evenement_id")
    private Evenement evenement;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    private Date date_res;

    @ManyToOne
    @JoinColumn(name = "methodePaiement_id")
    private MethodePaiement methodePaiement;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;
}


