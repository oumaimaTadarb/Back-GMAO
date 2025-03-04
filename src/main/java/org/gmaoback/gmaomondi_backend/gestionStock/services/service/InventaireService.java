package org.gmaoback.gmaomondi_backend.gestionStock.services.service;

import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.Inventaire;
import org.gmaoback.gmaomondi_backend.gestionStock.services.dto.InventaireDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InventaireService {
    Inventaire addNewInventaire(InventaireDTO inventaireDto);
    Inventaire updateInventaire(Long id, InventaireDTO inventaireDTO);
    Inventaire updateData(Inventaire existingInventaire, InventaireDTO inventaireDto);
    void deleteInventaire(Long id);
    List<InventaireDTO> listInventairesDTO();
    Page<Inventaire> findAll(Pageable pageable);
    Inventaire loadInventaireById(Long id);
    InventaireDTO loadInventaireByInventaireId(Long id);
    List<Inventaire> listInventaires();
//    Inventaire saveInventaire(Inventaire inventaire);
//    Inventaire updateInventaire(Inventaire inventaire);
//    Inventaire getInventaireById(Long idInventaire);
//    List<Inventaire> getAllInventaires();
//   void deleteInventaireById(Long idInventaire);
//
//    Page<Inventaire> getAllInventairesByPage(int page, int size);
}
