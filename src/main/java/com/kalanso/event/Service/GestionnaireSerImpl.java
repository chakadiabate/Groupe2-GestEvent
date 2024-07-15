package com.kalanso.event.Service;

import com.kalanso.event.Model.Gestionnaire;
import com.kalanso.event.Repository.GestionnaireRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Setter
@Getter
@Service
@AllArgsConstructor

public class GestionnaireSerImpl implements GestionnaireService{

    private GestionnaireRepo gestionnaireRepo;


    @Override
    public Gestionnaire CreerGestionnaire(Gestionnaire gestionnaire) {
        return gestionnaireRepo.save(gestionnaire);
    }

    @Override
    public List<Gestionnaire> listeGestionnaire() {
        return gestionnaireRepo.findAll();
    }

    @Override
    public Gestionnaire modifierGestionnaire(Integer id, Gestionnaire gestionnaire) {
        return gestionnaireRepo.findById(id)
                .map(p->{
                    p.setNom(gestionnaire.getNom());
                    p.setPrenom(gestionnaire.getPrenom());
                    p.setEmail(gestionnaire.getEmail());
                    p.setTelephone(gestionnaire.getTelephone());
                    p.setMotDePasse(gestionnaire.getMotDePasse());
                    return gestionnaireRepo.save(p);
                }).orElseThrow(()->new RuntimeException("Id non trouvé pour modifier gestionnaire"));
    }

    @Override
    public String SupprimerGestionnaire(Integer id) {
        gestionnaireRepo.deleteById(id);
        return "Gestionnaire supprimer avec succès";
    }
}
