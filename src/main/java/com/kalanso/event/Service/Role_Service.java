package com.kalanso.event.Service;

import com.kalanso.event.Model.RoleUser;
import com.kalanso.event.Repository.RoleRepo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class Role_Service {
    private RoleRepo roleRepo;

    public RoleUser AjouterRole(RoleUser Ro){
        return roleRepo.save(Ro);
    }

    public List<RoleUser> ListeRole(){
        return roleRepo.findAll();
    }

    public String supprimer(long id){
        roleRepo.deleteById(id);
        return "Role supprimer avec succès";
    }

    public RoleUser ModifierCategorie(long id, RoleUser roleUser){
        return roleRepo.findById(id)
                .map(R->{
                    R.setRole(roleUser.getRole());
                    return roleRepo.save(R);
                }).orElseThrow(()-> new RuntimeException("Role non trouvée"));
    }


}
