package com.kalanso.event.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private LocalDate date;
    private String description;
    private Integer nombrePlace;
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "categories")
    private CategorieEvent category;

    @OneToMany(mappedBy = "evenement")
    private List<Notification> notification;

    @OneToMany(mappedBy = "evenement")
    private List<Derouler> derouler;

    // Getters, setters, constructeurs
}