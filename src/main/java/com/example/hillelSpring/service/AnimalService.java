package com.example.hillelSpring.service;

import com.example.hillelSpring.model.Animal;
import com.example.hillelSpring.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal getAnimal(Integer id) {
        return animalRepository.findAnimalById(1);
    }

}
