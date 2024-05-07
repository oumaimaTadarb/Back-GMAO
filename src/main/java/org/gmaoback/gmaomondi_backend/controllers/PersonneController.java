package org.gmaoback.gmaomondi_backend.controllers;
import org.gmaoback.gmaomondi_backend.dao.entities.Personne;
import org.gmaoback.gmaomondi_backend.dto.PersonneDTO;
import org.gmaoback.gmaomondi_backend.services.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("**")
@RestController
@RequestMapping("api/personnes")
public class PersonneController {

    private final PersonneService personneService;

    @Autowired
    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    @GetMapping("/")
    public List<Personne> getAllPersonnes() {
        return personneService.listPersonnes();
    }

    @GetMapping("/dto")
    public List<PersonneDTO> getAllPersonnesDTO() {
        return personneService.listPersonnesDTO();
    }

    @GetMapping("/{id}")
    public PersonneDTO getPersonneById(@PathVariable Long id) {
        return personneService.loadPersonneByPersonneId(id);
    }

    @PostMapping("/add-personne")
    public ResponseEntity<String> addNewPersonne(@RequestBody PersonneDTO personneDto) {
        if (personneService.addNewPersonne(personneDto) != null) {
            return ResponseEntity.ok("La personne a été ajoutée avec succès");
        } else {
            return ResponseEntity.badRequest().body("Une erreur s'est produite lors de l'ajout de la personne");
        }
    }

    @PutMapping("/update-personne/{id}")
    public ResponseEntity<String> updatePersonne(@PathVariable Long id, @RequestBody PersonneDTO personneDto) {
        if (personneService.updatePersonne(id, personneDto) != null) {
            return ResponseEntity.ok("La personne a été modifiée avec succès");
        } else {
            return ResponseEntity.badRequest().body("Une erreur s'est produite lors de la modification de la personne");
        }
    }

    @DeleteMapping("/delete-personne/{id}")
    public ResponseEntity<String> deletePersonne(@PathVariable Long id) {
        personneService.deletePersonne(id);
        return ResponseEntity.ok("La personne a été supprimée avec succès");
    }
}

//    @GetMapping("/page")
//    public Page<Personne> getAllPersonnesByPage(@RequestParam("page") int page, @RequestParam("size") int size) {
//        return personneService.getAllPersonnesByPage(page, size);
//    }
//
//    @PostMapping("/savePersonne")
//    public Personne savePersonne(@RequestBody Personne personne) {
//        return personneService.savePersonne(personne);
//    }
//
//    @PutMapping("/{id}")
//    public Personne updatePersonne(@PathVariable("id") Long id, @RequestBody Personne personne) {
//        personne.setIdPersonne(id);
//        return personneService.updatePersonne(personne);
//    }
//
//    @GetMapping("/{id}")
//    public Personne getPersonneById(@PathVariable("id") Long id) {
//        return personneService.getPersonneById(id);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deletePersonneById(@PathVariable("id") Long id) {
//        personneService.deletePersonneById(id);
//    }
//
//    @GetMapping
//    public List<Personne> getAllPersonnes() {
//        return personneService.getAllPersonnes();
//    }
//


