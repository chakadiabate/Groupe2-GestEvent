package com.kalanso.event.Service;

import com.kalanso.event.Model.Admin;
import com.kalanso.event.Repository.AdminRepo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Setter
@Getter
@AllArgsConstructor

public class AdminServiceImpl implements AdminService{

    private final AdminRepo adminRepo;

    @Override
    public Admin creerAdmin(Admin admin) {

        return adminRepo.save(admin);
    }

    @Override
    public List<Admin> listerAdmin() {
        return adminRepo.findAll();
    }

    @Override
    public Admin modifierAdmin(Long id, Admin admin) {

            return adminRepo.findById(id)
                    .map(p->{
                        p.setNom(admin.getNom());
                        p.setPrenom(admin.getPrenom());
                        p.setEmail(admin.getEmail());
                        p.setTelephone(admin.getTelephone());
                        p.setMotDePasse(admin.getMotDePasse());
                        return adminRepo.save(p);
                    }) .orElseThrow(()->new RuntimeException("id NON trouvé!!"));
    }

    @Override
    public String supprimerAdmin(Long id) {
        adminRepo.deleteById(id);
        return "Admin Supprimer";
    }
}
