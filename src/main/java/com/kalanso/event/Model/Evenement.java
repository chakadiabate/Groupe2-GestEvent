package com.kalanso.event.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "evenements")
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private LocalDate date;
    private String lieu;
    private String description;
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    // Getters, setters, constructeurs
}
