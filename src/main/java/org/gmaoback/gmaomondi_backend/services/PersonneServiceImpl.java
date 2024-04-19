package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.entites.Personne;
import org.gmaoback.gmaomondi_backend.repositories.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonneServiceImpl implements PersonneService {
    @Autowired
    PersonneRepository personneRepository;
    @Override
    public Personne savePersonne(Personne personne) {
        return personneRepository.save(personne);
    }
    @Override
    public Personne updatePersonne(Personne personne) {
        return personneRepository.save(personne);
    }
    @Override
    public Personne getPersonneById(Long idBC) {
        return personneRepository.findById(idBC).get();
    }

    @Override
    public List<Personne> getAllPersonnes() {
        return personneRepository.findAll();
    }
    //@Override
    // public List<Personne> finAllByIdFournisseur(Long idFournisseur) {
    //     return personneRepository.findAllByIdFournisseur(IdFournisseur);
    // }

   

    @Override
    public void deletePersonneById(Long idPersonne) {
        personneRepository.deleteById(idPersonne);
    }
}
