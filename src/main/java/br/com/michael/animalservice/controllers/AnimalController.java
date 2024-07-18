package br.com.michael.animalservice.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import br.com.michael.animalservice.entity.Animal;
import br.com.michael.animalservice.repository.AnimalRepository;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private AnimalRepository repository;

    public AnimalController(AnimalRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    private List<Animal> findAll() {
        return repository.findAll();
    }

    @GetMapping("/type")
    private List<Animal> findByType(@RequestParam String type) {
        if (!type.equalsIgnoreCase("dog") && !type.equalsIgnoreCase("cat")) {
            throw new IllegalArgumentException("Type must be either 'dog' or 'cat'");
        }

        return repository.findByAnimalType(type);
    }

    @PostMapping()
    private Animal create(@RequestBody Animal animal) {

        if (animal.getAnimalType() == null || (!animal.getAnimalType().equalsIgnoreCase("dog") && !animal.getAnimalType().equalsIgnoreCase("cat"))) {
            throw new IllegalArgumentException("Animal type must be either 'dog' or 'cat'");
        }

        return repository.save(animal);
    }

    @GetMapping("/not-adoption")
    private List<Animal> findNotAdoption() {
        return repository.findNotAdoption();
    }

    @GetMapping("/adoption")
    private List<Animal> findAdoption() {
        return repository.findAdoption();
    }

    @GetMapping("/rescued-count")
    private Map<String, Long> countAnimalsByRecipientBetweenDates(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {

        List<Object[]> results = repository.countAnimalsByRecipientBetweenDates(startDate, endDate);
        Map<String, Long> countByRecipient = new HashMap<>();

        for (Object[] result : results) {
            String nameRecipient = (String) result[0];
            Long count = (Long) result[1];
            countByRecipient.put(nameRecipient, count);
        }

        return countByRecipient;
    }

}
