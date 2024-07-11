package com.kalanso.gevent.Repository;


import com.kalanso.gevent.Model.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvenementRepository extends JpaRepository<Evenement, Long> {
}

