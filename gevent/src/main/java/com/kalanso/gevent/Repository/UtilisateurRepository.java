package com.kalanso.gevent.Repository;

import com.kalanso.gevent.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByUsername(String username);

    Optional<Object> findByEmail(String email);
}

