package com.kalanso.gevent.Repository;

import com.kalanso.gevent.Model.Evenement;
import com.kalanso.gevent.Model.TypeTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeTicketRepository extends JpaRepository<TypeTicket, Long> {
}
