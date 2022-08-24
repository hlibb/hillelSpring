package com.example.hillelSpring.controller;

import com.example.hillelSpring.model.Animal;
import com.example.hillelSpring.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AnimalController {
    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping({"/id"})
    public Animal getAnimal(@PathVariable Integer id) {
        System.out.println(id);
        return animalService.getAnimal(id);
    }

    @GetMapping
    public List<Animal> getAllAnimals() {
        System.out.println("Getting all animals");
        return new ArrayList<>();
    }

    @PostMapping
    public Animal updateAnimal(@RequestBody Animal animal) {
        System.out.println(animal);
        return animal;
    }

    @PutMapping
    public Animal saveAnimal(@RequestBody Animal animal) {
        System.out.println(animal);
        return animal;
    }

    @DeleteMapping
    public void deleteAnimal(@RequestParam Integer id) {
        System.out.println(id);
    }
}
