package com.kalanso.event.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "lieu")
@NoArgsConstructor
public class Lieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String adresse;
    private String salle;
    private Integer capacite;
    // Getters, setters, constructeurs
}
