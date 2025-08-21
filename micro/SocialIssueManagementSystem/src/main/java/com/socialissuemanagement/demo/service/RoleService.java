package com.socialissuemanagement.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialissuemanagement.demo.entities.Role;
import com.socialissuemanagement.demo.repository.RoleRepository;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Integer id) {
        return roleRepository.findById(id).orElse(null);
    }

    public Role updateRole(Integer id, Role updatedRole) {
        Role role = getRoleById(id);
        if (role != null) {
            role.setRname(updatedRole.getRname());
            return roleRepository.save(role);
        }
        return null;
    }

    public void deleteRole(Integer id) {
        roleRepository.deleteById(id);
    }
}
