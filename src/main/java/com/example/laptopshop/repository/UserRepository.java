package com.example.laptopshop.repository;

import com.example.laptopshop.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User save(User user);
}
