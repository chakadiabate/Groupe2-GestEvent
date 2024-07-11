package com.kalanso.gevent.Repository;

import com.kalanso.gevent.Model.Evenement;
import com.kalanso.gevent.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
