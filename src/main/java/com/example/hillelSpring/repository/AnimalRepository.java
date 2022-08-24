package com.example.hillelSpring.repository;

import com.example.hillelSpring.model.Animal;
import org.springframework.stereotype.Repository;

@Repository
public class AnimalRepository {
    public Animal findAnimalById (int id) {
        return Animal.builder()
                .type("Cat")
                .age("2")
                .noise("Myau")
                .build();
    }
}
