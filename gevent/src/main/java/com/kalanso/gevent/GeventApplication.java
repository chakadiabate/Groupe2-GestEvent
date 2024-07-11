package com.kalanso.gevent;

import com.kalanso.gevent.Model.Role;
import com.kalanso.gevent.Model.Utilisateur;
import com.kalanso.gevent.Repository.RoleRepository;
import com.kalanso.gevent.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class GeventApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeventApplication.class, args);
    }




    @Configuration
    public class DataInitializer {

        @Autowired
        private UtilisateurRepository utilisateurRepository;

        @Autowired
        private RoleRepository roleRepository;

        @Autowired
        private PasswordEncoder passwordEncoder;

        @Bean
        CommandLineRunner init() {
            return args -> {
                // Vérifiez si le rôle admin existe, sinon, créez-le
                Optional<Object> adminRoleOpt = roleRepository.findByName("ROLE_ADMIN");
                Role adminRole;
                if (!adminRoleOpt.isPresent()) {
                    adminRole = new Role();
                    adminRole.setName("ROLE_ADMIN");
                    roleRepository.save(adminRole);
                } else {
                    adminRole = (Role) adminRoleOpt.get();
                }

                // Vérifiez si l'utilisateur admin existe, sinon, créez-le
                Optional<Utilisateur> adminUserOpt = utilisateurRepository.findByUsername("admin");
                if (!adminUserOpt.isPresent()) {
                    Utilisateur adminUser = new Utilisateur();
                    adminUser.setUsername("admin");
                    adminUser.setPassword(passwordEncoder.encode("1234"));
                    adminUser.setEmail("soumbounou.saran@gmail.com");
                    Set<Role> roles = new HashSet<>();
                    roles.add(adminRole);
                    adminUser.setRoles(roles);
                    utilisateurRepository.save(adminUser);
                }
            };
        }
    }
}
