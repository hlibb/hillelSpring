package com.example.hillelSpring.service;

import com.example.hillelSpring.model.Animal;
import com.example.hillelSpring.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal getAnimalById(int id) {
        return animalRepository.findById(id);
    }

    public List<Animal> getAllAnimals() {
        return (List<Animal>) animalRepository.getAllAnimals();
    }

    public Animal saveAnimal(Animal animal) {
        //animalRepository.save(animal);
        //return animalRepository.findById((int)animal.getAnimal_id());
        return Animal.builder().type("fish").age(1).noise("bul'-bul'").build();
    }

    public Animal updateAnimal(Integer id, Animal updatedAnimal) {
        System.out.println(animalRepository.updateAnimal(
                updatedAnimal.getType(),
                updatedAnimal.getAge(),
                updatedAnimal.getNoise(),
                id));
        return animalRepository.findById((int) id);
    }

    public void deleteAnimal(Integer id) {
        animalRepository.deleteById(id);
    }

}
