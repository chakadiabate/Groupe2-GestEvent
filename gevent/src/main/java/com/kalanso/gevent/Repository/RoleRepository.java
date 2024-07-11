package com.kalanso.gevent.Repository;

import com.kalanso.gevent.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Object> findByName(String name);
}
