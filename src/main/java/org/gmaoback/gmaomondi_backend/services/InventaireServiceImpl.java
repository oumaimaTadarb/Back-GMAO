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
        return inventaireRepository.save(inventaire);
    }

    @Override
    public Inventaire updateInventaire(Inventaire inventaire) {
        if (inventaireRepository.existsById(inventaire.getIdInventaire())) {
            return inventaireRepository.save(inventaire);
        } else {
            throw new IllegalArgumentException("Inventaire non trouvé avec l'identifiant : " + inventaire.getIdInventaire());
        }
    }

    @Override
    public Inventaire getInventaireById(Long idInventaire) {
        return inventaireRepository.findById(idInventaire)
                .orElseThrow(() -> new IllegalArgumentException("Inventaire non trouvé avec l'identifiant : " + idInventaire));
    }

    @Override
    public List<Inventaire> getAllInventaires() {
        return inventaireRepository.findAll();
    }

    @Override
    public void deleteInventaireById(Long idInventaire) {
        inventaireRepository.deleteById(idInventaire);
    }

    @Override
    public Page<Inventaire> getAllInventairesByPage(int page, int size) {
     return inventaireRepository.findAll(PageRequest.of(page, size));
    }

}
