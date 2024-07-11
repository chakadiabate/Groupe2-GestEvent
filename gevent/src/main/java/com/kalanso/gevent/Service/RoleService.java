package com.kalanso.gevent.Service;

import com.kalanso.gevent.Model.Role;
import com.kalanso.gevent.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public Role getRoleById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role non trouvé avec l'ID : " + id));
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role updateRole(Long id, Role roleDetails) {
        Role role = getRoleById(id);

        role.setName(roleDetails.getName());

        return roleRepository.save(role);
    }

    public void deleteRole(Long id) {
        Role role = getRoleById(id);
        roleRepository.delete(role);
    }

    public Role getRoleByName(String name) {
        return (Role) roleRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Role non trouvé avec le nom : " + name));
    }
}

