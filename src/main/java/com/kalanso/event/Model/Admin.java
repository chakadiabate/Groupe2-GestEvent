package com.kalanso.event.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Table(name="ADMIN")
@Entity
@NoArgsConstructor
public class Admin extends Utilisateur{

}
