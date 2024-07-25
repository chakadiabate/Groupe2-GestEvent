package com.kalanso.event.Model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@Getter
@Setter
public class Utilisateur implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String prenom;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String telephone;

    //@Column(unique = true)
    private String motDePasse;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleUser role;

    @OneToMany(mappedBy = "utilisateur")
    private List<Evenement> evenement;

    @OneToMany(mappedBy = "utilisateur")
    private List<Reservation> reservation;

    @OneToMany(mappedBy = "utilisateur")
    private List<Notification> notification;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.motDePasse;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}