package com.kalanso.event.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private Date date = new Date();
    private Date datedebut ;
    private Date datefin ;
    private String description;
    private Integer nombrePlace;

    @ManyToOne
    @JoinColumn(name = "typeEvent_id")
    private TypeEvent typeevent;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "categories")
    private CategorieEvent category;

    @OneToMany(mappedBy = "evenement")
    private List<Notification> notification;

    @OneToMany(mappedBy = "evenement")
    private List<Derouler> derouler;

    @OneToMany(mappedBy = "evenement")
    private List<Reservation> reservation;

    // Getters, setters, constructeurs
}