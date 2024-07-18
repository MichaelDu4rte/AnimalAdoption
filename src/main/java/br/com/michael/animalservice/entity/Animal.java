package br.com.michael.animalservice.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String animalType;

    @Column(nullable = false)
    private String nameEstimated;

    @Column(nullable = false)
    private Integer ageEstimated;

    @Column(nullable = false)
    private String breed;

    @Column(nullable = false)
    private Date dateEntry;

    @Column
    private Date dateAdoption;

    @Column(nullable = false)
    private String ConditionsArrival;

    @Column(nullable = false)
    private String nameRecipient;

    @Column
    private Date Datedeath;

    @Column(nullable = false)
    private String shapePhysical;

    //getters and setters
    public Integer getId() {
        return this.id;
    }

    public String getNameEstimated() {
        return this.nameEstimated;
    }

    public void setNameEstimated(String nameEstimated) {
        this.nameEstimated = nameEstimated;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public Integer getAgeEstimated() {
        return this.ageEstimated;
    }

    public void setAgeEstimated(Integer ageEstimated) {
        this.ageEstimated = ageEstimated;
    }

    public String getBreed() {
        return this.breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Date getDateEntry() {
        return this.dateEntry;
    }

    public void setDateEntry(Date dateEntry) {
        this.dateEntry = dateEntry;
    }

    public Date getDateAdoption() {
        return this.dateAdoption;
    }

    public void setDateAdoption(Date dateAdoption) {
        this.dateAdoption = dateAdoption;
    }

    public String getConditionsArrival() {
        return this.ConditionsArrival;
    }

    public void setConditionsArrival(String ConditionsArrival) {
        this.ConditionsArrival = ConditionsArrival;
    }

    public String getNameRecipient() {
        return this.nameRecipient;
    }

    public void setNameRecipient(String nameRecipient) {
        this.nameRecipient = nameRecipient;
    }

    public Date getDatedeath() {
        return this.Datedeath;
    }

    public void setDatedeath(Date Datedeath) {
        this.Datedeath = Datedeath;
    }

    public String getShapePhysical() {
        return this.shapePhysical;
    }

    public void setShapePhysical(String shapePhysical) {
        this.shapePhysical = shapePhysical;
    }

}
