package com.kalanso.event.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;
    @ManyToOne
    @JoinColumn(name = "evenement_id")
    private Evenement evenement;
    private String type;
    private LocalDateTime dateEnvoi;
    private String moyen;
    private String statutEnvoi;
    // Getters, setters, constructeurs
}
