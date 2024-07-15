package com.kalanso.event.Service;

import com.kalanso.event.Model.Role;
import com.kalanso.event.Repository.RoleRepo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class Role_Service {
    private RoleRepo roleRepo;

    public Role AjouterRole(Role Ro){
        return roleRepo.save(Ro);
    }

    public List<Role> ListeRole(){
        return roleRepo.findAll();
    }

    public String supprimer(long id){
        roleRepo.deleteById(id);
        return "Role supprimer avec succès";
    }

    public Role ModifierCategorie(long id, Role role){
        return roleRepo.findById(id)
                .map(R->{
                    R.setNom(role.getNom());
                    return roleRepo.save(R);
                }).orElseThrow(()-> new RuntimeException("Role non trouvée"));
    }


}
