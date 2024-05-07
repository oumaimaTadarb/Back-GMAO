package org.gmaoback.gmaomondi_backend.services.impl;

import org.gmaoback.gmaomondi_backend.dao.entites.Personne;
import org.gmaoback.gmaomondi_backend.dao.repositories.PersonneRepository;
import org.gmaoback.gmaomondi_backend.services.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonneServiceImpl implements PersonneService {

    @Autowired
    private PersonneRepository personneRepository;

    @Override
    public Personne savePersonne(Personne personne) {
        try {
            return personneRepository.save(personne);
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de l'enregistrement de la personne : " + e.getMessage());
        }
    }

    @Override
    public Personne updatePersonne(Personne personne) {
        try {
            if (personneRepository.existsById(personne.getIdPersonne())) {
                return personneRepository.save(personne);
            } else {
                throw new IllegalArgumentException("Personne non trouvée avec l'identifiant : " + personne.getIdPersonne());
            }
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la mise à jour de la personne : " + e.getMessage());
        }
    }

    @Override
    public Personne getPersonneById(Long idPersonne) {
        try {
            return personneRepository.findById(idPersonne)
                    .orElseThrow(() -> new IllegalArgumentException("Personne non trouvée avec l'identifiant : " + idPersonne));
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération de la personne par ID : " + e.getMessage());
        }
    }

    @Override
    public List<Personne> getAllPersonnes() {
        try {
            return personneRepository.findAll();
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération de toutes les personnes : " + e.getMessage());
        }
    }

    @Override
    public void deletePersonneById(Long idPersonne) {
        try {
            personneRepository.deleteById(idPersonne);
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la suppression de la personne par ID : " + e.getMessage());
        }
    }

    @Override
    public Page<Personne> getAllPersonnesByPage(int page, int size) {
        try {
            return personneRepository.findAll(PageRequest.of(page, size));
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération des personnes par page : " + e.getMessage());
        }
    }
}
