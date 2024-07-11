package com.kalanso.gevent.Repository;

import com.kalanso.gevent.Model.Evenement;
import com.kalanso.gevent.Model.TypeEvenement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeEvenementRepository extends JpaRepository<TypeEvenement, Long> {
}
