package com.kalanso.event.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="GESTIONNAIRE")
@NoArgsConstructor
@Getter
@Setter
public class Gestionnaire extends Utilisateur{
}
