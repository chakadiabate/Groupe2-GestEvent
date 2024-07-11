package com.kalanso.gevent.Model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class TypeTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

    @OneToMany(mappedBy = "typeTicket")
    private Set<Posseder> posseders = new HashSet<>();

    // Getters et Setters
}

