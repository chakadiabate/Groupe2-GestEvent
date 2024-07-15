package com.kalanso.event.Service;

import com.kalanso.event.Model.Organisateur;
import com.kalanso.event.Repository.OrgaRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Setter
@Getter
@AllArgsConstructor

public class OrgaServiceImpl implements OrgaService{

    private final OrgaRepo orgaRepo;

    @Override
    public Organisateur creerOrganisateur(Organisateur organisateur) {
        return orgaRepo.save(organisateur);
    }

    @Override
    public List<Organisateur> listerOrganisateur() {
        return orgaRepo.findAll();
    }

    @Override
    public Organisateur modifierOrganisateur(Integer id, Organisateur organisateur) {
        return orgaRepo.findById(id)
                .map(p->{
                        p.setNom(organisateur.getNom());
                        p.setPrenom(organisateur.getPrenom());
                        p.setEmail(organisateur.getEmail());
                        p.setTelephone(organisateur.getTelephone());
                        p.setMotDePasse(organisateur.getMotDePasse());
                        return orgaRepo.save(p);
                    }) .orElseThrow(()->new RuntimeException("id NON trouvé!!"));
    }

    @Override
    public String supprimerOrganisateur(Integer id) {
        orgaRepo.deleteById(id);
        return "Organisateur supprimer";
    }
}
