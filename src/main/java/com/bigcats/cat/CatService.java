package com.bigcats.cat;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CatService {
    
    @Autowired
  private CatRepository catRepository;

  /**
   * Method to get all students
   *
   * @return List of all students
   */
  public Object getAllCats() {
    return catRepository.findAll();
  }

  /**
   * Method to get a student by ID
   *
   * @param studentId The ID of the student to retrieve
   * @return The student with the specified ID
   */
  public Cat getCatById(@PathVariable long catId) {
    return catRepository.findById(catId).orElse(null);
  }

  /**
   * Method to get students by name
   *
   * @param name The name of the student to search for
   * @return List of students with the specified name
   */
  public Object getCatsByName(String name) {
    return catRepository.getCatsByName(name);
  }

  /**
   * Method to get students by major
   *
   * @param major The major to search for
   * @return List of students with the specified major
   */
  public Object getCatsByBreed(String breed) {
    return catRepository.getCatsByBreed(breed);
  }

  /**
   * Fetch all students with a GPA above a threshold.
   *
   * @param gpa the threshold
   * @return the list of matching Students
   */
  public Object getCatsByAge(int age) {
    return catRepository.getCatsByAge(age);
  }

  /**
   * Method to add a new student
   *
   * @param student The student to add
   */
  public Cat addCat(Cat cat) {
    return catRepository.save(cat);
  }

  /**
   * Method to update a student
   *
   * @param studentId The ID of the student to update
   * @param student   The updated student information
   */
  public Cat updateCat(Long catId, Cat cat) {
    return catRepository.save(cat);
  }

  /**
   * Method to delete a student
   *
   * @param studentId The ID of the student to delete
   */
  public void deleteCat(Long catId) {
    catRepository.deleteById(catId);
  }

  /**
   * Method to write a student object to a JSON file
   *
   * @param student The student object to write
   */
  public String writeJson(Cat cat) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      objectMapper.writeValue(new File("students.json"), cat);
      return "Cat written to JSON file successfully";
    } catch (IOException e) {
      e.printStackTrace();
      return "Error writing cat to JSON file";
    }

  }

  /**
   * Method to read a student object from a JSON file
   *
   * @return The student object read from the JSON file
   */
  public Object readJson() {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.readValue(new File("cats.json"), Cat.class);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }

  }
}
