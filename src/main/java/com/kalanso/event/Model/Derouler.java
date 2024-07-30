package com.kalanso.event.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
@Table(name = "derouler")
public class Derouler {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "lieu_id")
    private Lieu lieu;

    @ManyToOne
    @JoinColumn(name = "evenement_id")
    private Evenement evenement;



}