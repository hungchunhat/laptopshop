package com.example.laptopshop.service;

import com.example.laptopshop.domain.User;
import com.example.laptopshop.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public String handleHello(){
        return "Hello from UserService!";
    }
    public User handleSaveUser(User user){
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
}
