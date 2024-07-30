package com.kalanso.event.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    private String telephone; // Changed from Integer to String for better handling of phone numbers
    private String profile;
    // Changed name to plural


    @ManyToOne
    @JoinColumn(name = "gestionnaire_id")
    //@JsonManagedReference("gestionnaire")
    private Gestionnaire gestionnaire;

}
