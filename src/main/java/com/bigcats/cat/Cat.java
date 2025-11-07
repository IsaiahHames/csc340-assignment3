package com.bigcats.cat;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cats")
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long catId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String breed;

    @Column(nullable = false)
    private int age;

    private String imagepath;

    @Column(nullable = false)
    private LocalDate dob;

    public Cat() {
    }

    public Cat(Long id, String name, String description, String breed, int age, String imagepath, LocalDate dob) {
        this.catId = id;
        this.name = name;
        this.description = description;
        this.breed = breed;
        this.age = age;
        this.imagepath = imagepath;
        this.dob = dob;
    }

    public Cat(String name, String description, String breed, int age, String imagepath, LocalDate dob) {
        this.name = name;
        this.description = description;
        this.breed = breed;
        this.age = age;
        this.imagepath = imagepath;
        this.dob = dob;
    }

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long id) {
        this.catId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagePath(String imagepath) {
        this.imagepath = imagepath;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
