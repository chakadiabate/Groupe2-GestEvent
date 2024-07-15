package com.kalanso.event.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "categories_billets")

public class CategorieBillet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String description;
    private Date datecreation;

    @PrePersist
    protected void onCreate() {
        this.datecreation = new Date();
    }

    @OneToMany(mappedBy = "categorieBillet")
    private List<Billet> billets;

}
