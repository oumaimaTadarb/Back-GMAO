package org.gmaoback.gmaomondi_backend.controllers;
import org.gmaoback.gmaomondi_backend.entites.Personne;
import org.gmaoback.gmaomondi_backend.services.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personnes")
public class PersonneController {

    @Autowired
    private PersonneService personneService;

    @PostMapping
    public Personne savePersonne(@RequestBody Personne personne) {
        return personneService.savePersonne(personne);
    }

    @PutMapping("/{id}")
    public Personne updatePersonne(@PathVariable("id") Long id, @RequestBody Personne personne) {
        personne.setIdPersonne(id); // Assurez-vous que l'ID de la personne est défini
        return personneService.updatePersonne(personne);
    }

    @GetMapping("/{id}")
    public Personne getPersonneById(@PathVariable("id") Long id) {
        return personneService.getPersonneById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePersonneById(@PathVariable("id") Long id) {
        personneService.deletePersonneById(id);
    }

    @GetMapping
    public List<Personne> getAllPersonnes() {
        return personneService.getAllPersonnes();
    }

    @GetMapping("/page")
    public Page<Personne> getAllPersonnesByPage(@RequestParam("page") int page, @RequestParam("size") int size) {
        return personneService.getAllPersonnesByPage(page, size);
    }
}
