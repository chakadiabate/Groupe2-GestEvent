package com.kalanso.event.Model;

import com.kalanso.event.Enumerations.MethodePaiement;
import com.kalanso.event.Enumerations.StatutReservation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Reservation")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private StatutReservation statut;

    @ManyToOne
    @JoinColumn(name = "evenement_id")
    private Evenement evenement;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    private Date date_res;
    private MethodePaiement methodePaiement;
}


