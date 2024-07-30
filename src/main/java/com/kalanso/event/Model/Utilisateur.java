package com.kalanso.event.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@Getter
@Setter
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String prenom;
    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String telephone;

    //@Column(unique = true)
    private String motDePasse;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleUser role;

    @OneToMany(mappedBy = "utilisateur")
    @JsonIgnoreProperties("utilisateur")
    private List<Evenement> evenement;

    @OneToMany(mappedBy = "utilisateur")
    @JsonIgnoreProperties("utilisateur")
    private List<Reservation> reservation;

    @OneToMany(mappedBy = "utilisateur")
    private List<Notification> notification;


}