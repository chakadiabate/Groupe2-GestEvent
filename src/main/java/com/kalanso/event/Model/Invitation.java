package com.kalanso.event.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Invitation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String motif;

    @ManyToOne
    @JoinColumn(name = "prestateur-id", nullable=false)
    private Prestateur prestateur;

    @ManyToOne
    @JoinColumn(name = "id_even", nullable=false)
    private Evenement evenement;

}
