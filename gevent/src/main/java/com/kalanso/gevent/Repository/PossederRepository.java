package com.kalanso.gevent.Repository;

import com.kalanso.gevent.Model.LieuEvenement;
import com.kalanso.gevent.Model.Posseder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PossederRepository extends JpaRepository<Posseder, Long> {
}
