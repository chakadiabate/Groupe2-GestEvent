package com.kalanso.event.Repository;

import com.kalanso.event.Model.RoleUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<RoleUser, Long> {
}