package br.com.michael.animalservice.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.michael.animalservice.entity.Animal;
import org.springframework.data.repository.query.Param;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    @Query("SELECT a FROM Animal a WHERE a.dateAdoption IS NULL ORDER BY a.dateEntry")
    List<Animal> findNotAdoption();

    @Query("SELECT a FROM Animal a WHERE a.dateAdoption IS NOT NULL")
    List<Animal> findAdoption();

    @Query("SELECT a FROM Animal a WHERE a.animalType = :type")
    List<Animal> findByAnimalType(@Param("type") String type);

    @Query("SELECT a.nameRecipient, COUNT(a) FROM Animal a WHERE a.dateEntry BETWEEN :startDate AND :endDate GROUP BY a.nameRecipient")
    List<Object[]> countAnimalsByRecipientBetweenDates(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
