package com.kalanso.event.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="ORGANISATEUR")
@Entity
public class Organisateur extends Utilisateur{

}
