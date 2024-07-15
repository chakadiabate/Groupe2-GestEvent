package com.kalanso.event.Repository;

import com.kalanso.event.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Reservation_repo extends JpaRepository<Reservation,Long> {
    List<Reservation> findByClientId(Long clientId);
    List<Reservation> findByEvenementId(Long evenementId);
}
