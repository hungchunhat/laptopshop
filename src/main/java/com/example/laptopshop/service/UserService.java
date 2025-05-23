package com.example.laptopshop.service;

import com.example.laptopshop.domain.Role;
import com.example.laptopshop.domain.User;
import com.example.laptopshop.repository.RoleRepository;
import com.example.laptopshop.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    UserService(UserRepository userRepository, PasswordEncoder passwordEncoder,
                RoleService roleService) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleService = roleService;

    }

    public User handleSaveUser(User user) {
        return this.userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public List<User> getUsersByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public User getUserById(long id) {
        return this.userRepository.findById(id);
    }

    public void deleteUserById(long id) {
        this.userRepository.deleteById(id);
    }
    public String encryptPassword(String password) {
        return this.passwordEncoder.encode(password);
    }
    public Role getRoleByName(String name) {
        return this.roleService.getRoleByName(name);
    }
    public User handleCreateUser(User user, String avatar){
        String hashPassword = encryptPassword(user.getPassword());
        user.setPassword(hashPassword);
        user.setAvatar(avatar);
        user.setRole(getRoleByName(user.getRole().getName()));
        return handleSaveUser(user);
    }
    public User handleUpdateUser(User user, String fileName){
        User user1 = this.getUserById(user.getId());
        if (user1 != null) {
            if(fileName != null && !fileName.isEmpty()){
                user1.setAvatar(fileName);
            }
            user1.setAddress(user.getAddress());
            user1.setPhone(user.getPhone());
            user1.setFullName(user.getFullName());
            user1.setRole(getRoleByName(user.getRole().getName()));
            handleSaveUser(user1);
        }
        return user1;
    }
    public boolean hasErrors(BindingResult bindingResult){
        List<FieldError> errors = bindingResult.getFieldErrors()
                .stream()
                .filter(fieldError -> !(fieldError.getField().equals("email") || fieldError.getField().equals(
                        "password")))
                .toList();
        if (!errors.isEmpty()) {
           errors.forEach(fieldError -> System.out.println(">>>>>> " + fieldError.getField() + " " + fieldError.getDefaultMessage()));
           return true;
        }
        return false;
    }

}
