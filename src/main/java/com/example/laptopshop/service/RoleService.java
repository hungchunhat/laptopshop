package com.example.laptopshop.service;

import com.example.laptopshop.domain.Role;
import com.example.laptopshop.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private final RoleRepository roleRepository;
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    public long getRoleCount() {
        return roleRepository.count();
    }
    public Role handleSaveRole(Role role) {
        return roleRepository.save(role);
    }
    public Role getRoleByName(String name) {
        return roleRepository.findByName(name);
    }
}
