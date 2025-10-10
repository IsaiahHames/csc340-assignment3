package com.bigcats.cat;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CatService {
    
    @Autowired
  private CatRepository catRepository;

  private static final String UPLOAD_DIR = "src/main/resources/static/profile-pictures/";

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
  public Cat addCat(Cat cat, MultipartFile profilePicture) {
    Cat newCat = catRepository.save(cat);
    String originalFileName = profilePicture.getOriginalFilename();

    try {
      if (originalFileName != null && originalFileName.contains(".")) {
        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        String fileName = String.valueOf(newCat.getCatId()) + "." + fileExtension;
        Path filePath = Paths.get(UPLOAD_DIR + fileName);

        InputStream inputStream = profilePicture.getInputStream();

        Files.createDirectories(Paths.get(UPLOAD_DIR));// Ensure directory exists
        Files.copy(inputStream, filePath,
            StandardCopyOption.REPLACE_EXISTING);// Save picture file
        newCat.setProfilePicturePath(fileName);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return catRepository.save(newCat);
  }

  /**
   * Method to update a student
   *
   * @param catId The ID of the student to update
   * @param cat   The updated student information
   */
  public Cat updateStudent(Long catId, Cat cat, MultipartFile profilePicture) {
    String originalFileName = profilePicture.getOriginalFilename();

    try {
      if (originalFileName != null && originalFileName.contains(".")) {
        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        String fileName = String.valueOf(catId) + "." + fileExtension;
        Path filePath = Paths.get(UPLOAD_DIR + fileName);

        InputStream inputStream = profilePicture.getInputStream();
        Files.deleteIfExists(filePath);
        Files.copy(inputStream, filePath,
            StandardCopyOption.REPLACE_EXISTING);// Save picture file
        cat.setProfilePicturePath(fileName);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return catRepository.save(cat);
  }

  /**
   * Method to delete a student
   *
   * @param catId The ID of the student to delete
   */
  public void deleteStudent(Long catId) {
    catRepository.deleteById(catId);
  }
}
