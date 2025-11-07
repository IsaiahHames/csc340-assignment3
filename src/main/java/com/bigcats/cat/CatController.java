package com.bigcats.cat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CatController {

    @Autowired
    private CatService catService;

    /**
     * Endpoint to get all cat
     *
     * @return List of all cat
     */
    @GetMapping({"/cats", "/cats/"})
    public Object getAllCats(Model model) {
        model.addAttribute("catsList", catService.getAllCats());
        return "cat-list";
    }

    /**
     * Endpoint to get a cat by ID
     *
     * @param id The ID of the cat to retrieve
     * @return The cat with the specified ID
     */
    @GetMapping("/cats/{id}")
    public String getcatById(@PathVariable long id, Model model) {
        model.addAttribute("cat", catService.getCatById(id));
        return "cat-details";
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
            return "cat-list";
        } else {
            return "redirect:/cats";
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
        return "cat-list";
    }

    /**
     * Endpoint to get cats with age above a specified threshold
     *
     * @param age The age threshold for cats
     * @return List of cats with age above the specified threshold
     */
    @GetMapping("/cats/age")
    public Object getCatsByAge(@RequestParam(name = "age", defaultValue = "1") int age) {
        return "cat-list";

    }

     /**
   * Endpoint to show the create form for a new cat
   *
   * @param model The model to add attributes to
   * @return The view name for the create form
   */

    @GetMapping("/cats/createForm")
    public Object showCreateForm(Model model) {
    Cat cat = new Cat();
    model.addAttribute("cat", cat);
    model.addAttribute("title", "Create New Cat");
    return "cat-create";
  }

    /**
     * Endpoint to add a new cat
     *
     * @param cat The cat to add
     * @return List of all cats
     */
    @PostMapping("/cats")
    public Object addCat(Cat cat, @RequestParam MultipartFile picture) {
        Cat newCat = catService.addCat(cat, picture);
        return "redirect:/cats/" + newCat.getCatId();
    }

    /**
   * Endpoint to show the update form for a cat
   *
   * @param id    The ID of the cat to update
   * @param model The model to add attributes to
   * @return The view name for the update form
   */
    @GetMapping("/cats/updateForm/{id}")
    public Object showUpdateForm(@PathVariable Long id, Model model) {
    Cat cat = catService.getCatById(id);
    model.addAttribute("cat", cat);
    model.addAttribute("title", "Update Cat: " + id);
    return "cat-update";
  }


    /**
     * Endpoint to update a cat
     *
     * @param id      The ID of the cat to update
     * @param cat The updated cat information
     * @return The updated cat
     */
    @PutMapping("/cats/update/{id}")
    public Object updateCat(@PathVariable Long id, @RequestBody Cat cat) {
        catService.updateCat(id, cat);
        return "redirect:/cats/" + id;
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
        return "redirect:/cats";
    }
}
