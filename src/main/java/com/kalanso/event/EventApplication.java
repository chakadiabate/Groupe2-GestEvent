package com.kalanso.event;

import com.kalanso.event.Model.Admin;
import com.kalanso.event.Model.RoleUser;
import com.kalanso.event.Model.Utilisateur;
import com.kalanso.event.Repository.RoleUserRepo;
import com.kalanso.event.Repository.Utilisateur_repo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@SpringBootApplication //(exclude = { SecurityAutoConfiguration.class })
public class EventApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner1(RoleUserRepo roleRepo) {
		return args -> {
			RoleUser roleUsers = roleRepo.findByRole("ADMIN");
			if (roleUsers == null) {
				RoleUser roleUser = new RoleUser();
				roleUser.setRole("ADMIN");
				System.out.println("hello3");
				roleRepo.save(roleUser);
			}

		};
	}

	@Bean
	public CommandLineRunner commandLineRunnerAdmin(PasswordEncoder passwordEncoder, Utilisateur_repo utilisateurRepo, RoleUserRepo roleUserRepo) {
		return args -> {
			Optional<Utilisateur> utilisateur = utilisateurRepo.findByEmail("Admin@odk.com");
			System.out.println("hello1");
			if(utilisateur.isEmpty()){
				System.out.println("hello2");
				Admin admin = new Admin();
				RoleUser roleUser = roleUserRepo.findByRole("ADMIN");
				admin.setEmail("Admin@odk.com");
				admin.setNom("Administrateur");
				admin.setPrenom("Administrateur");
				admin.setMotDePasse(passwordEncoder.encode("Admin@odk.com"));
				admin.setTelephone("+22372834301");
				admin.setRole(roleUser);
				utilisateurRepo.save(admin);
			}
		};
	}

}
