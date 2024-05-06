package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.dao.entites.Inventaire;
import org.gmaoback.gmaomondi_backend.dao.repositories.InventaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InventaireServiceImpl implements InventaireService {

    @Autowired
    private InventaireRepository inventaireRepository;

    @Override
    public Inventaire saveInventaire(Inventaire inventaire) {
        try {
            return inventaireRepository.save(inventaire);
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de l'enregistrement de l'inventaire : " + e.getMessage());
        }
    }

    @Override
    public Inventaire updateInventaire(Inventaire inventaire) {
        try {
            if (inventaireRepository.existsById(inventaire.getIdInventaire())) {
                return inventaireRepository.save(inventaire);
            } else {
                throw new IllegalArgumentException("Inventaire non trouvé avec l'identifiant : " + inventaire.getIdInventaire());
            }
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la mise à jour de l'inventaire : " + e.getMessage());
        }
    }

    @Override
    public Inventaire getInventaireById(Long idInventaire) {
        try {
            return inventaireRepository.findById(idInventaire)
                    .orElseThrow(() -> new IllegalArgumentException("Inventaire non trouvé avec l'identifiant : " + idInventaire));
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération de l'inventaire par ID : " + e.getMessage());
        }
    }

    @Override
    public List<Inventaire> getAllInventaires() {
        try {
            return inventaireRepository.findAll();
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération de tous les inventaires : " + e.getMessage());
        }
    }

    @Override
    public void deleteInventaireById(Long idInventaire) {
        try {
            inventaireRepository.deleteById(idInventaire);
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la suppression de l'inventaire par ID : " + e.getMessage());
        }
    }

    @Override
    public Page<Inventaire> getAllInventairesByPage(int page, int size) {
        try {
            return inventaireRepository.findAll(PageRequest.of(page, size));
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération des inventaires par page : " + e.getMessage());
        }
    }
}
