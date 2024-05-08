package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.dao.entities.Personne;
import org.gmaoback.gmaomondi_backend.dto.PersonneDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonneService {
    Personne addNewPersonne(PersonneDTO personneDto);
    Personne updatePersonne(Long id, PersonneDTO personneDTO);
    Personne updateData(Personne Personne, PersonneDTO personneDto);
    void deletePersonne(Long id);
    List<PersonneDTO> listPersonnesDTO();
    List<Personne> listPersonnes();
    Personne loadPersonneById(Long id);
    PersonneDTO loadPersonneByPersonneId(Long id);
    Personne loadPersonneBySpecialite(String specialite);
    Personne loadPersonneByNom(String nom);



//    Personne savePersonne(Personne personne);
//    Personne updatePersonne(Personne personne);
//    Personne getPersonneById(Long idPersonne);
//    List<Personne> getAllPersonnes();
//     void deletePersonneById(Long idPersonne);
//    Page<Personne> getAllPersonnesByPage(int page, int size);
}
