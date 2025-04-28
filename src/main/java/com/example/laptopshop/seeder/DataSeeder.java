package com.example.laptopshop.seeder;

import com.example.laptopshop.domain.Role;
import com.example.laptopshop.service.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {
    private final RoleService roleService;
    DataSeeder(RoleService roleService) {
        this.roleService = roleService;
    }
    @Override
    public void run(String... args) throws Exception {
        if(roleService.getRoleCount() == 0){
            Role role = new Role();
            role.setName("ADMIN");
            role.setDescription("Admin thì full quyền");
            System.out.println("Tạo thành công role: " + roleService.handleSaveRole(role));
            Role role2 = new Role();
            role2.setName("USER");
            role2.setDescription("User bình thường");
            System.out.println("Tạo thành công role: " + roleService.handleSaveRole(role2));
        }
    }
}
