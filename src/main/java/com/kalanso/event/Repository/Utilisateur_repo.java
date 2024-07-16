package com.kalanso.event.Repository;

import com.kalanso.event.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Utilisateur_repo extends JpaRepository<Utilisateur, Integer> {
    Optional<Utilisateur> findByEmail(String email);
}
