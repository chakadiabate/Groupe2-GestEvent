package com.kalanso.event.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class StatutReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long Id;
    private String statut;
    @JsonBackReference(value = "users")
    @OneToMany(mappedBy = "statut")
    private List<Reservation> reservation;

}