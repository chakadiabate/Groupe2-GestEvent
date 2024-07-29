package com.kalanso.event.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Gestionnaire extends Utilisateur{

    @OneToMany(mappedBy = "gestionnaire")
    @JsonIgnore
    private List<Prestateur> prestateur;
}
