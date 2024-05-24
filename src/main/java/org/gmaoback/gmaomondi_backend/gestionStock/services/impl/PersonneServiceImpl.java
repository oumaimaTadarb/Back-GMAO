package org.gmaoback.gmaomondi_backend.gestionStock.services.impl;

import jakarta.persistence.EntityNotFoundException;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.Personne;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories.PersonneRepository;
import org.gmaoback.gmaomondi_backend.gestionStock.dto.PersonneDTO;
import org.gmaoback.gmaomondi_backend.gestionStock.services.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonneServiceImpl implements PersonneService {

    @Autowired
    private PersonneRepository personneRepository;

    @Override
    public Personne addNewPersonne(PersonneDTO personneDto) {
        Personne personne = new Personne();
        personne.setNom(personneDto.getNom());
        personne.setPrenom(personneDto.getPrenom());
        personne.setSpecialite(personneDto.getSpecialite());
        personne.setTel(personneDto.getTel());
        personne.setEmail(personneDto.getEmail());
        return this.personneRepository.save(personne);
    }

    @Transactional
    @Override
    public Personne updatePersonne(Long id, PersonneDTO personneDto) {
        Personne personne = this.personneRepository.findById(id).orElse(null);
        if (personne != null) {
            personne.setNom(personneDto.getNom());
            personne.setPrenom(personneDto.getPrenom());
            personne.setSpecialite(personneDto.getSpecialite());
            personne.setTel(personneDto.getTel());
            personne.setEmail(personneDto.getEmail());

            return this.personneRepository.save(personne);
        }
        return null;
    }

    @Override
    public Personne updateData(Personne personne, PersonneDTO personneDto) {
        personne.setNom(personneDto.getNom());
        personne.setPrenom(personneDto.getPrenom());
        personne.setSpecialite(personneDto.getSpecialite());
        personne.setTel(personneDto.getTel());
        personne.setEmail(personneDto.getEmail());
        return personne;
    }


    @Override
    public void deletePersonne(Long id) {
        personneRepository.deleteById(id);
        Personne personne = personneRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Personne non trouvée"));

        personneRepository.delete(personne);
    }


    @Override
    public List<PersonneDTO> listPersonnesDTO() {
        List<Personne> personnes = this.personneRepository.findAll();
        List<PersonneDTO> personnesDTO = personnes.stream()
                .map(this::convertToPersonneDTO)
                .collect(Collectors.toList());
        return personnesDTO;
    }


    public PersonneDTO convertToPersonneDTO(Personne personne) {
        if (personne == null) {
            return null;
        }
        PersonneDTO personneDto = new PersonneDTO();
        personneDto.setIdPersonne(personne.getIdPersonne());
        personneDto.setNom(personne.getNom());
        personneDto.setPrenom(personne.getPrenom());
        personneDto.setSpecialite(personne.getSpecialite());
        personneDto.setTel(personne.getTel());
        personneDto.setEmail(personne.getEmail());
        return personneDto;
    }


@Override
    public List<Personne> listPersonnes() {
        return this.personneRepository.findAll();
    }

    @Override
    public Personne loadPersonneBySpecialite(String specialite) {
            return this.personneRepository.findBySpecialite(specialite);
        }

    @Override
    public Personne loadPersonneById(Long id) {
        return personneRepository.findById(id).orElse(null);
    }

    @Override
    public PersonneDTO loadPersonneByPersonneId(Long id) {
        Personne personne = this.personneRepository.findById(id).orElse(null);
        if (personne == null) {
            return null;
        }
        PersonneDTO personneDto = new PersonneDTO();
        personneDto.setNom(personne.getNom());
        personneDto.setPrenom(personne.getPrenom());
        personneDto.setSpecialite(personne.getSpecialite());
        personneDto.setTel(personne.getTel());
        personneDto.setEmail(personne.getEmail());


        return personneDto;
    }
@Override
    public Personne loadPersonneByNom(String nom) {
        return personneRepository.findByNom(nom);
    }

}

//    @Override
//    public Personne savePersonne(Personne personne) {
//        try {
//            return personneRepository.save(personne);
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de l'enregistrement de la personne : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public Personne updatePersonne(Personne personne) {
//        try {
//            if (personneRepository.existsById(personne.getIdPersonne())) {
//                return personneRepository.save(personne);
//            } else {
//                throw new IllegalArgumentException("Personne non trouvée avec l'identifiant : " + personne.getIdPersonne());
//            }
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la mise à jour de la personne : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public Personne getPersonneById(Long idPersonne) {
//        try {
//            return personneRepository.findById(idPersonne)
//                    .orElseThrow(() -> new IllegalArgumentException("Personne non trouvée avec l'identifiant : " + idPersonne));
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération de la personne par ID : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public List<Personne> getAllPersonnes() {
//        try {
//            return personneRepository.findAll();
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération de toutes les personnes : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public void deletePersonneById(Long idPersonne) {
//        try {
//            personneRepository.deleteById(idPersonne);
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la suppression de la personne par ID : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public Page<Personne> getAllPersonnesByPage(int page, int size) {
//        try {
//            return personneRepository.findAll(PageRequest.of(page, size));
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération des personnes par page : " + e.getMessage());
//        }
//    }

