package org.gmaoback.gmaomondi_backend.gestionStock.controllers;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.Personne;
import org.gmaoback.gmaomondi_backend.gestionStock.dto.PersonneDTO;
import org.gmaoback.gmaomondi_backend.gestionStock.services.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("api/personnes")
public class PersonneController {

    @Autowired
    private PersonneService personneService;

    @PostMapping("/add")
    public ResponseEntity<Personne> addNewPersonne(@RequestBody PersonneDTO personneDto) {
        Personne personne = personneService.addNewPersonne(personneDto);
        return new ResponseEntity<>(personne, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Personne> updatePersonne(@PathVariable Long id, @RequestBody PersonneDTO personneDTO) {
        Personne personne = personneService.updatePersonne(id, personneDTO);
        return new ResponseEntity<>(personne, HttpStatus.OK);
    }

    @PutMapping("/updateData/{id}")
    public ResponseEntity<Personne> updateData(@PathVariable Long id, @RequestBody PersonneDTO personneDTO) {
        Personne personne = personneService.updateData(personneService.loadPersonneById(id), personneDTO);
        return new ResponseEntity<>(personne, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePersonne(@PathVariable Long id) {
        personneService.deletePersonne(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/listDTO")
    public ResponseEntity<List<PersonneDTO>> listPersonnesDTO() {
        List<PersonneDTO> personnesDTO = personneService.listPersonnesDTO();
        return new ResponseEntity<>(personnesDTO, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Personne>> listPersonnes() {
        List<Personne> personnes = personneService.listPersonnes();
        return new ResponseEntity<>(personnes, HttpStatus.OK);
    }

    @GetMapping("/specialite/{specialite}")
    public ResponseEntity<Personne> loadPersonneBySpecialite(@PathVariable String specialite) {
        Personne personne = personneService.loadPersonneBySpecialite(specialite);
        return new ResponseEntity<>(personne, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personne> loadPersonneById(@PathVariable Long id) {
        Personne personne = personneService.loadPersonneById(id);
        return new ResponseEntity<>(personne, HttpStatus.OK);
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<PersonneDTO> loadPersonneByPersonneId(@PathVariable Long id) {
        PersonneDTO personneDTO = personneService.loadPersonneByPersonneId(id);
        return new ResponseEntity<>(personneDTO, HttpStatus.OK);
    }

    @GetMapping("/nom/{nom}")
    public ResponseEntity<Personne> loadPersonneByNom(@PathVariable String nom) {
        Personne personne = personneService.loadPersonneByNom(nom);
        return new ResponseEntity<>(personne, HttpStatus.OK);
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


