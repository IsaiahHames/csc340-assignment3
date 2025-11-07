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

  private static final String UPLOAD_DIR = "src/main/resources/static/pictures/";

  /**
   * Method to get all cats
   *
   * @return List of all cats
   */
  public Object getAllCats() {
    return catRepository.findAll();
  }

  /**
   * Method to get a cat by ID
   *
   * @param catId The ID of the cat to retrieve
   * @return The cat with the specified ID
   */
  public Cat getCatById(@PathVariable long catId) {
    return catRepository.findById(catId).orElse(null);
  }

  /**
   * Method to get cats by name
   *
   * @param name The name of the cat to search for
   * @return List of cats with the specified name
   */
  public Object getCatsByName(String name) {
    return catRepository.getCatsByName(name);
  }

  /**
   * Method to get cats by breed
   *
   * @param breed The breed to search for
   * @return List of cats with the specified breed
   */
  public Object getCatsByBreed(String breed) {
    return catRepository.getCatsByBreed(breed);
  }

  /**
   * Fetch all cats with a age above a threshold.
   *
   * @param age the threshold
   * @return the list of matching cats
   */
  public Object getCatsByAge(int age) {
    return catRepository.getCatsByAge(age);
  }

  /**
   * Method to add a new cat
   *
   * @param cat The cat to add
   */
  public Cat addCat(Cat cat, MultipartFile picture) {
    Cat newCat = catRepository.save(cat);
    String originalFileName = picture.getOriginalFilename();

    try {
      if (originalFileName != null && originalFileName.contains(".")) {
        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        String fileName = String.valueOf(newCat.getCatId()) + "." + fileExtension;
        Path filePath = Paths.get(UPLOAD_DIR + fileName);

        InputStream inputStream = picture.getInputStream();

        Files.createDirectories(Paths.get(UPLOAD_DIR));// Ensure directory exists
        Files.copy(inputStream, filePath,
            StandardCopyOption.REPLACE_EXISTING);// Save picture file
        newCat.setImagePath(fileName);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return catRepository.save(newCat);
  }

  /**
   * Method to update a cat
   *
   * @param catId The ID of the cat to update
   * @param cat   The updated cat information
   */
  public Cat updateCat(Long catId, Cat cat) {
    return catRepository.save(cat);
  }

  /**
   * Method to delete a cat
   *
   * @param catId The ID of the cat to delete
   */
  public void deleteCat(Long catId) {
    catRepository.deleteById(catId);
  }
}
