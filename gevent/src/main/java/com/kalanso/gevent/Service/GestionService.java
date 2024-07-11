package com.kalanso.gevent.Service;

import com.kalanso.gevent.Model.Gestion;
import com.kalanso.gevent.Repository.GestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionService {

    @Autowired
    private GestionRepository gestionRepository;

    public Gestion saveGestion(Gestion gestion) {
        return gestionRepository.save(gestion);
    }

    public Gestion getGestionById(Long id) {
        return gestionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Gestion non trouvée avec l'ID : " + id));
    }

    public List<Gestion> getAllGestions() {
        return gestionRepository.findAll();
    }

    public Gestion updateGestion(Long id, Gestion gestionDetails) {
        Gestion gestion = getGestionById(id);
        gestion.setEvenement(gestionDetails.getEvenement());
        gestion.setUtilisateur(gestionDetails.getUtilisateur());
        return gestionRepository.save(gestion);
    }

    public void deleteGestion(Long id) {
        Gestion gestion = getGestionById(id);
        gestionRepository.delete(gestion);
    }
}

