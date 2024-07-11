package br.com.michael.animalservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.michael.animalservice.entity.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

}
