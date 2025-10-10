package com.bigcats.cat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatController {

    @Autowired
    private CatService catService;

    /**
     * Endpoint to get all cat
     *
     * @return List of all cat
     */
    @GetMapping("/cats")
    public Object getAllCats() {
        return catService.getAllCats();
    }

    /**
     * Endpoint to get a cat by ID
     *
     * @param id The ID of the cat to retrieve
     * @return The cat with the specified ID
     */
    @GetMapping("/cats/{id}")
    public Cat getcatById(@PathVariable long id) {
        return catService.getCatById(id);
    }

    /**
     * Endpoint to get cats by name
     *
     * @param name The name of the cat to search for
     * @return List of cats with the specified name
     */
    @GetMapping("/cats/name")
    public Object getCatsByName(@RequestParam String key) {
        if (key != null) {
            return catService.getCatsByName(key);
        } else {
            return catService.getAllCats();
        }

    }

    /**
     * Endpoint to get cats by breed
     *
     * @param breed The breed to search for
     * @return List of cats with the specified breed
     */
    @GetMapping("/cats/breed/{breed}")
    public Object getCatsByBreed(@PathVariable String breed) {
        return catService.getCatsByBreed(breed);
    }

    /**
     * Endpoint to get cats with age above a specified threshold
     *
     * @param age The age threshold for cats
     * @return List of cats with age above the specified threshold
     */
    @GetMapping("/cats/age")
    public Object getCatsByAge(@RequestParam(name = "age", defaultValue = "1") int age) {
        return new ResponseEntity<>(catService.getCatsByAge(age), HttpStatus.OK);

    }

    /**
     * Endpoint to add a new cat
     *
     * @param cat The cat to add
     * @return List of all cats
     */
    @PostMapping("/cats")
    public Object addCat(@RequestBody Cat cat) {
        return catService.addCat(cat);
    }

    /**
     * Endpoint to update a cat
     *
     * @param id      The ID of the cat to update
     * @param cat The updated cat information
     * @return The updated cat
     */
    @PutMapping("/cats/{id}")
    public Cat updateCat(@PathVariable Long id, @RequestBody Cat cat) {
        catService.updateCat(id, cat);
        return catService.getCatById(id);
    }

    /**
     * Endpoint to delete a cat
     *
     * @param id The ID of the cat to delete
     * @return List of all cats
     */
    @DeleteMapping("/cats/{id}")
    public Object deleteCat(@PathVariable Long id) {
        catService.deleteCat(id);
        return catService.getAllCats();
    }

    /**
     * Endpoint to write a cat to a JSON file
     *
     * @param cat The cat to write
     * @return An empty string indicating success
     */
    @PostMapping("/cats/writeFile")
    public Object writeJson(@RequestBody Cat cat) {
        return catService.writeJson(cat);
    }

    /**
     * Endpoint to read a JSON file and return its contents
     *
     * @return The contents of the JSON file
     */
    @GetMapping("/cats/readFile")
    public Object readJson() {
        return catService.readJson();

    }
}
