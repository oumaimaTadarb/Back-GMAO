package org.gmaoback.gmaomondi_backend.gestionStock.services.service;

import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.BonLivraison;
import org.gmaoback.gmaomondi_backend.gestionStock.dto.BonLivraisonDTO;

import java.util.List;

public interface BonLivraisonService {


    BonLivraison addNewBonLivraison(BonLivraisonDTO bonLivraisonDto);

    BonLivraison updateBonLivraison(Long id, BonLivraisonDTO bonLivraisonDTO);

    void deleteBonLivraison(Long id);

    List<BonLivraisonDTO> listBonLivraisonsDTO();

    List<BonLivraison> listBonLivraisons();

    BonLivraison loadBonLivraisonById(Long id);

    BonLivraisonDTO loadBonLivraisonDTOById(Long id);

    BonLivraison loadBonLivraisonByCodeSap(Long codeSapBL);

}

//    BonLivraison updateBonLivraisonByCodeSapBL(Long codeSapBL, BonLivraison updatedBonLivraison);
//    void deleteBonLivraisonByCodeSapBL(Long codeSapBL);
//    BonLivraison getBonLivraisonByCodeSapBL(Long codeSapBL);
//    Page<BonLivraison> getAllBonLivraisonByPage(int page, int size);
//    BonLivraison saveBonLivraison(BonLivraison bonLivraison);
//    BonLivraison updateBonLivraison(BonLivraison bonLivraison);
//    BonLivraison getBonLivraisonById(Long idBL);
//    List<BonLivraison> getAllBonLivraison();
//    void deleteBonLivraisonById(Long idBL);




//   BonLivraison updateBonLivraisonByCodeSapBL(Long codeSapBL, BonLivraison updatedBonLivraison);
//    void deleteBonLivraisonByCodeSapBL(Long codeSapBL);
//
//
//    BonLivraison getBonLivraisonByCodeSapBL(Long codeSapBL);
//
//    Page<BonLivraison> getAllBonLivraisonByPage(int page, int size);
//
//   // BonLivraison saveBonLivraison(BonLivraison bonLivraison);
//
//    BonLivraison updateBonLivraison(BonLivraison bonLivraison);
//
//    BonLivraison getBonLivraisonById(Long idBL);
//
//    List<BonLivraison> getAllBonLivraison();
//
//    void deleteBonLivraisonById(Long idBL);
//
//    BonLivraison saveBonLivraison(BonLivraison bonLivraison);

