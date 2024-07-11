package com.kalanso.event.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "ventes")
public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "billet_id")
    private Billet billet;
    @ManyToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;
    private LocalDateTime dateVente;
    private BigDecimal montant;
    // Getters, setters, constructeurs
}
