package com.kalanso.gevent.Service;


import com.kalanso.gevent.Model.Evenement;
import com.kalanso.gevent.Repository.EvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvenementService {

    @Autowired
    private EvenementRepository evenementRepository;

    public Evenement saveEvenement(Evenement evenement) {
        return evenementRepository.save(evenement);
    }

    public Evenement getEvenementById(Long id) {
        return evenementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Événement non trouvé avec l'ID : " + id));
    }

    public List<Evenement> getAllEvenements() {
        return evenementRepository.findAll();
    }

    public Evenement updateEvenement(Long id, Evenement evenementDetails) {
        Evenement evenement = getEvenementById(id);
        evenement.setNom(evenementDetails.getNom());
        evenement.setDescription(evenementDetails.getDescription());
        // Mettre à jour les autres champs nécessaires
        return evenementRepository.save(evenement);
    }

    public void deleteEvenement(Long id) {
        Evenement evenement = getEvenementById(id);
        evenementRepository.delete(evenement);
    }
}

