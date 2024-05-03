package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.dao.entites.Personne;
import org.gmaoback.gmaomondi_backend.dao.repositories.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonneServiceImpl implements PersonneService {

    @Autowired
    private PersonneRepository personneRepository;

//    @Override
//    public Personne savePersonne(Personne personne) {
//        return personneRepository.save(personne);
//    }
//
//    @Override
//    public Personne updatePersonne(Personne personne) {
//        if (personneRepository.existsById(personne.getIdPersonne())) {
//            return personneRepository.save(personne);
//        } else {
//            throw new IllegalArgumentException("Personne non trouvée avec l'identifiant : " + personne.getIdPersonne());
//        }
//    }
//
//    @Override
//    public Personne getPersonneById(Long idPersonne) {
//        return personneRepository.findById(idPersonne)
//                .orElseThrow(() -> new IllegalArgumentException("Personne non trouvée avec l'identifiant : " + idPersonne));
//    }
//
//    @Override
//    public List<Personne> getAllPersonnes() {
//        return personneRepository.findAll();
//    }
//
//    @Override
//    public void deletePersonneById(Long idPersonne) {
//        personneRepository.deleteById(idPersonne);
//    }

    @Override
    public Page<Personne> getAllPersonnesByPage(int page, int size) {
        return personneRepository.findAll(PageRequest.of(page, size));
    }


}
