package com.kalanso.gevent.Service;

import com.kalanso.gevent.Model.LieuEvenement;
import com.kalanso.gevent.Repository.LieuEvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LieuEvenementService {

    @Autowired
    private LieuEvenementRepository lieuEvenementRepository;

    public LieuEvenement saveLieuEvenement(LieuEvenement lieuEvenement) {
        return lieuEvenementRepository.save(lieuEvenement);
    }

    public LieuEvenement getLieuEvenementById(Long id) {
        return lieuEvenementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lieu d'événement non trouvé avec l'ID : " + id));
    }

    public List<LieuEvenement> getAllLieuEvenements() {
        return lieuEvenementRepository.findAll();
    }

    public LieuEvenement updateLieuEvenement(Long id, LieuEvenement lieuEvenementDetails) {
        LieuEvenement lieuEvenement = getLieuEvenementById(id);
        lieuEvenement.setNom(lieuEvenementDetails.getNom());
        lieuEvenement.setAdresse(lieuEvenementDetails.getAdresse());
        return lieuEvenementRepository.save(lieuEvenement);
    }

    public void deleteLieuEvenement(Long id) {
        LieuEvenement lieuEvenement = getLieuEvenementById(id);
        lieuEvenementRepository.delete(lieuEvenement);
    }
}

