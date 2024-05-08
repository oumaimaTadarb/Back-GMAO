package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.dao.entities.Inventaire;
import org.gmaoback.gmaomondi_backend.dao.entities.Inventaire;
import org.gmaoback.gmaomondi_backend.dto.InventaireDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InventaireService {
    Inventaire addNewInventaire(InventaireDTO inventaireDto);
    Inventaire updateInventaire(Long id, InventaireDTO inventaireDTO);
    Inventaire updateData(Inventaire Inventaire, InventaireDTO inventaireDto);
    void deleteInventaire(Long id);
    List<InventaireDTO> listInventairesDTO();
    List<Inventaire> listInventaires();
    Inventaire loadInventaireById(Long id);
    InventaireDTO loadInventaireByInventaireId(Long id);
//    Inventaire saveInventaire(Inventaire inventaire);
//    Inventaire updateInventaire(Inventaire inventaire);
//    Inventaire getInventaireById(Long idInventaire);
//    List<Inventaire> getAllInventaires();
//   void deleteInventaireById(Long idInventaire);
//
//    Page<Inventaire> getAllInventairesByPage(int page, int size);
}
