package com.example.hillelSpring.repository;

import com.example.hillelSpring.model.Animal;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AnimalRepository extends CrudRepository<Animal, Integer> {
    @Query("SELECT * FROM animals WHERE id =:id")
    public Animal findById(@Param("id") int id);

    @Query("SELECT * FROM animals")
    public List<Animal> getAllAnimals();

    @Query("UPDATE animals SET type = ':type', age = ':age', noise = ':noise' WHERE id = ':id'")
    public Animal updateAnimal(@Param("type") String type,
                               @Param("age") int age,
                               @Param("noise") String noise,
                               @Param("id") Integer id);
}

