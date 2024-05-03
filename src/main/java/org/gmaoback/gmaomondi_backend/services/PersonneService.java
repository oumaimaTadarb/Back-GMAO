package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.dao.entites.Personne;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonneService {
//    Personne savePersonne(Personne personne);
//    Personne updatePersonne(Personne personne);
//    Personne getPersonneById(Long idPersonne);
//    List<Personne> getAllPersonnes();
//     void deletePersonneById(Long idPersonne);
    Page<Personne> getAllPersonnesByPage(int page, int size);
}
