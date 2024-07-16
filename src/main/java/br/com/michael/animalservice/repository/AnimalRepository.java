package br.com.michael.animalservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.michael.animalservice.entity.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    @Query("SELECT a FROM Animal a WHERE a.dateAdoption IS NULL ORDER BY a.dateEntry")
    List<Animal> findNotAdoption();

    @Query("SELECT a FROM Animal a WHERE a.dateAdoption IS NOT NULL")
    List<Animal> findAdoption();
}
