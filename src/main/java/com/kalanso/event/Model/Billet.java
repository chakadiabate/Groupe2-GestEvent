package com.kalanso.event.Model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Billet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_evenement", nullable = false)
    private Evenement evenement;

    private String typeBillet;
    private int prix;
    private int quantiteDisponible;
    private LocalDate dateDebutVente;
    private LocalDate dateFinVente;
    private String description;
    private String lienQrCode;

    @ManyToOne
    @JoinColumn(name = "Statuts")
    private StatutBillet status;

    @ManyToOne
    @JoinColumn(name = "Categories")
    private CategorieBillet category;



}
