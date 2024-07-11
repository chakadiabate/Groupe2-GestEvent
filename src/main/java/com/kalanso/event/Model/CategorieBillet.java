package com.kalanso.event.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "categories_billets")
public class CategorieBillet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String description;
    // Getters, setters, constructeurs
}
