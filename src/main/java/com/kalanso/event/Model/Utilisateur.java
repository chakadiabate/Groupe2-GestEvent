package com.kalanso.event.Model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.relation.Role;

@Entity
@Table(name = "utilisateur")
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@Getter
@Setter

public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;

    @Column(unique = true)
    private String Email;

    @Column(unique = true)
    private Long telephone;

    @Column(unique = true)
    private String motDePasse;

    @OneToOne
    private Role role;

}