package com.kalanso.event.Controller;

import com.kalanso.event.Model.Admin;
import com.kalanso.event.Service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Utilisateur/Admin")
@AllArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/CreerAdmin")
    public Admin CreerAdmin(@RequestBody Admin admin){
        return adminService.creerAdmin(admin);
    }

    @GetMapping("/ListeAdmin")
    List<Admin> listerAdmin(){
        return adminService.listerAdmin();
    }

    @PutMapping("/ModifierAdmin/{id}")
    public Admin modifierAdmin(@PathVariable Long id, @RequestBody Admin admin){
        return adminService.modifierAdmin(id, admin);
    }

    @DeleteMapping("/SupprmierAdmin/{id]}")
    public  String supprimerAdmin( @PathVariable Long id){
        return adminService.supprimerAdmin(id);
    }
}
