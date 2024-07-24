package com.kalanso.event.Controller;

import com.kalanso.event.Model.RoleUser;
import com.kalanso.event.Service.Role_Service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins="*")
@Controller
@RestController
@RequestMapping("gestEvent/role")
@AllArgsConstructor
public class RoleController {

    private final Role_Service roleService;

    @PostMapping("/AjouterRoles")
    public RoleUser AjouterRole(@RequestBody RoleUser role) {
        return roleService.AjouterRole(role);
    }

    @GetMapping("/listeRole")
    public List<RoleUser> ListeRole() {
        return roleService.ListeRole();
    }

    @DeleteMapping("/supCathegorie/{id}")
    public String SupCategorie(@PathVariable Long id) {
        return roleService.supprimer(id);
    }

    @PutMapping("/modifCategorie/{id}")
    public RoleUser modifierCategorie(@PathVariable Long id, @RequestBody RoleUser role) {
        return roleService.ModifierCategorie(id, role);
    }
}
