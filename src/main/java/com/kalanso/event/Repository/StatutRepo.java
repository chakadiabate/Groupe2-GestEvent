package com.kalanso.event.Repository;

import com.kalanso.event.Model.StatutReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatutRepo extends JpaRepository<StatutReservation, Integer> {
    StatutReservation findByStatut(String Statut);
}
