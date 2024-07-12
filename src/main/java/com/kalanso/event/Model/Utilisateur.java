package com.kalanso.event.Model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String username;
    private String motDePasse;

    @Enumerated(EnumType.STRING)
    private TypeRole role;

    public Utilisateur(String username, String motDePasse, TypeRole role) {
        this.username = username;
        this.motDePasse = motDePasse;
        this.role = role;
    }
}