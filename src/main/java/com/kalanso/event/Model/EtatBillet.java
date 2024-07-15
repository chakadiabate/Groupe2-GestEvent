package com.kalanso.event.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TYPEROLE")
@Data
@NoArgsConstructor
@Getter
@Setter
public class EtatBillet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long Id;

    private String etatBillet;

}