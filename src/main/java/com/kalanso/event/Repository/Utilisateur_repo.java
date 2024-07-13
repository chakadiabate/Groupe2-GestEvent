package com.kalanso.event.Repository;

import com.kalanso.event.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Utilisateur_repo extends JpaRepository<Utilisateur, Integer> {

    List<Utilisateur> findAllById(String id);
}
