package org.gmaoback.gmaomondi_backend.gmaomondi_backend.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.gmaomondi_backend.gmaomondi_backend.dao.entites.Inventaire;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InventaireService {
    Inventaire saveInventaire(Inventaire inventaire);
    Inventaire updateInventaire(Inventaire inventaire);
    Inventaire getInventaireById(Long idBC);
    List<Inventaire> getAllInventaires();
   void deleteInventaireById(Long idBC);

    Page<Inventaire> getAllInventairesByPage(int page, int size);
}
