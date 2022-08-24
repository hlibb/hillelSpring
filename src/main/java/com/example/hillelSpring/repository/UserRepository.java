package com.example.hillelSpring.repository;

import com.example.hillelSpring.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public User findUserById (int id) {
        return User.builder()
                .name("Hlib")
                .surname("Astashev")
                .age(21)
                .gender(true)
                .build();
    }
}
