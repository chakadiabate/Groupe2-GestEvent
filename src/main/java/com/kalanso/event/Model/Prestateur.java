package com.kalanso.event.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Prestateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    private String email;
    private Integer tel;
    private Integer email;

    @OneToMany(mappedBy = "prestateur")
    private List<Equipement> equipement;

    @ManyToOne
    @JoinColumn(name = "gestionnaire_id")
    private Gestionnaire gestionnaire;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RolePrestateur role;
}
