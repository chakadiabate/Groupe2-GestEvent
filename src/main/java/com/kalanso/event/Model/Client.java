package com.kalanso.event.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="CLIENT")
public class Client extends Utilisateur{

    public Client(String username, String motDePasse){
        super(username, motDePasse, TypeRole.CLIENT);
    }
}
