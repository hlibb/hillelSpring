package com.example.hillelSpring.controller;

import com.example.hillelSpring.model.Animal;
import com.example.hillelSpring.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class AnimalController {
    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("animals/{id}")
    public Animal getAnimal(@PathVariable Integer id) {
        System.out.println(id);
        return animalService.getAnimalById(id);
    }

    @GetMapping
    public List<Animal> getAllAnimals() {
        System.out.println("Getting all animals");
        return animalService.getAllAnimals();
    }

    @PostMapping(value = "animals/{id}", produces = "application/json")
    public void updateAnimal(Integer id, @RequestBody Animal animal) {
        System.out.println(animalService.updateAnimal(id, animal));
    }

    @PutMapping
    public Animal saveAnimal(@RequestBody Animal animal) {
        System.out.println(animalService.saveAnimal(animal));
        return animal;
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public void deleteAnimal(@PathVariable Integer id) {
        if (id == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        System.out.println("Animal: " + animalService.getAnimalById(id) + "is about to be deleted");
        animalService.deleteAnimal(id);
    }
}
