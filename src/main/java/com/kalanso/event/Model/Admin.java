package com.kalanso.event.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="ADMIN")
@Entity
public class Admin extends Utilisateur{
    public Admin( String username, String motDepasse){
        super (username, motDepasse, TypeRole.ADMIN);
    }
}
