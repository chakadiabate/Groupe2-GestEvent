package com.kalanso.event.Controller;

import com.kalanso.event.Model.RoleUser;
import com.kalanso.event.Service.Role_Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestEvent/role")
@AllArgsConstructor
public class RoleController {

    private Role_Service roleService;

    @PutMapping("/AjouterRoles")
    public RoleUser AjouterRole(RoleUser R){
        return roleService.AjouterRole(R);
    }

    @GetMapping("/listeRole")
    public List<RoleUser> ListeRole(){
        return roleService.ListeRole();
    }

    @DeleteMapping("/supCathegorie")
    public String SupCategorie(Long id){
        return roleService.supprimer(id);
    }
    @PutMapping("/modifCategorie")
    public RoleUser modifierategorie(Long id, RoleUser R){
        return roleService.ModifierCategorie(id, R);
    }

}
