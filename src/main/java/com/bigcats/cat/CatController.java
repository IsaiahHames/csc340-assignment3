package com.bigcats.cat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CatController {

    @Autowired
    private CatService catService;

    /**
     * Endpoint to get all students
     *
     * @return List of all students
     */
    @GetMapping("/cats")
    public Object getAllStudents() {
        return catService.getAllCats();
    }

    /**
     * Endpoint to get a student by ID
     *
     * @param id The ID of the student to retrieve
     * @return The student with the specified ID
     */
    @GetMapping("/cats/{id}")
    public Cat getcatById(@PathVariable long id) {
        return catService.getCatById(id);
    }

    /**
     * Endpoint to get students by name
     *
     * @param name The name of the student to search for
     * @return List of students with the specified name
     */
    @GetMapping("/cat/name")
    public Object getCatsByName(@RequestParam String key) {
        if (key != null) {
            return catService.getCatsByName(key);
        } else {
            return catService.getAllCats();
        }

    }

    /**
     * Endpoint to get students by major
     *
     * @param major The major to search for
     * @return List of students with the specified major
     */
    @GetMapping("/cats/breed/{breed}")
    public Object getCatsByBreed(@PathVariable String breed) {
        return catService.getCatsByBreed(breed);
    }

    /**
     * Endpoint to get honors students with GPA above a specified threshold
     *
     * @param gpa The GPA threshold for honors students
     * @return List of honors students with GPA above the specified threshold
     */
    @GetMapping("/cats/age")
    public Object getCatsByAge(@RequestParam(name = "age", defaultValue = "1") int age) {
        return new ResponseEntity<>(catService.getCatsByAge(age), HttpStatus.OK);

    }

    /**
     * Endpoint to add a new student
     *
     * @param student The student to add
     * @return List of all students
     */
    @PostMapping("/cats")
    public Object addCat(@RequestBody Cat cat) {
        return catService.addCat(cat);
    }

    /**
     * Endpoint to update a student
     *
     * @param id      The ID of the student to update
     * @param student The updated student information
     * @return The updated student
     */
    @PutMapping("/cat/{id}")
    public Cat updateStudent(@PathVariable Long id, @RequestBody Cat cat) {
        catService.updateCat(id, cat);
        return catService.getCatById(id);
    }

    /**
     * Endpoint to delete a student
     *
     * @param id The ID of the student to delete
     * @return List of all students
     */
    @DeleteMapping("/cat/{id}")
    public Object deleteStudent(@PathVariable Long id) {
        catService.deleteCat(id);
        return catService.getAllCats();
    }

    /**
     * Endpoint to write a student to a JSON file
     *
     * @param student The student to write
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
