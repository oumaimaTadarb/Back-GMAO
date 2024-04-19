package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.entites.Inventaire;
import org.gmaoback.gmaomondi_backend.repositories.InventaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class InventaireServiceImpl implements  InventaireService{
    @Autowired
    InventaireRepository inventaireRepository;
    @Override
    public Inventaire saveInventaire(Inventaire inventaire) {
        return inventaireRepository.save(inventaire);
    }
    @Override
    public Inventaire updateInventaire(Inventaire inventaire) {
        return inventaireRepository.save(inventaire);
    }
    @Override
    public Inventaire getInventaireById(Long idBC) {
        return inventaireRepository.findById(idBC).get();
    }

    @Override
    public List<Inventaire> getAllInventaires() {
        return inventaireRepository.findAll();
    }
    //@Override
    // public List<Inventaire> finAllByIdFournisseur(Long idFournisseur) {
    //     return inventaireRepository.findAllByIdFournisseur(IdFournisseur);
    // }

    @Override
    public Page<Inventaire> getAllArticlesByPage(int page, int size) {
        return inventaireRepository.findAll(PageRequest.of(page,size));
    }
}
