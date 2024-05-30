package org.gmaoback.gmaomondi_backend.gestionStock.services.impl;

import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.BonLivraison;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories.BonLivraisonRepository;
import org.gmaoback.gmaomondi_backend.gestionStock.dto.BonLivraisonDTO;
import org.gmaoback.gmaomondi_backend.gestionStock.services.service.BonLivraisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BonLivraisonServiceImpl implements BonLivraisonService {
    @Autowired
    private BonLivraisonRepository bonLivraisonRepository;
    @Override
    public BonLivraison addNewBonLivraison(BonLivraisonDTO bonLivraisonDto) {
            BonLivraison bonLivraison = new BonLivraison();
            bonLivraison.setCodeSapBL(bonLivraisonDto.getCodeSapBL());
            bonLivraison.setDateReception(LocalDateTime.now());
            bonLivraison.setDocumentBL(bonLivraisonDto.getDocumentBL());
            bonLivraison.setIdRecepteur(bonLivraisonDto.getIdRecepteur());
            bonLivraison.setStatus(bonLivraisonDto.getStatus());

            return bonLivraisonRepository.save(bonLivraison);
        }


    @Override
    public BonLivraison updateBonLivraison(Long id, BonLivraisonDTO bonLivraisonDTO) {
        Optional<BonLivraison> optionalBonLivraison = bonLivraisonRepository.findById(id);
        if (optionalBonLivraison.isPresent()) {
            BonLivraison bonLivraison = optionalBonLivraison.get();
            bonLivraison.setCodeSapBL(bonLivraisonDTO.getCodeSapBL());
            bonLivraison.setDateReception(LocalDateTime.now());
            bonLivraison.setDocumentBL(bonLivraisonDTO.getDocumentBL());
            bonLivraison.setIdRecepteur(bonLivraisonDTO.getIdRecepteur());
            bonLivraison.setStatus(bonLivraisonDTO.getStatus());
            // Set other properties if needed

            return bonLivraisonRepository.save(bonLivraison);
        } else {
            throw new RuntimeException("BonLivraison with id " + id + " not found");
        }
    }

    @Override
    public void deleteBonLivraison(Long id) {
        Optional<BonLivraison> optionalBonLivraison = bonLivraisonRepository.findById(id);
        if (optionalBonLivraison.isPresent()) {
            BonLivraison bonLivraison = optionalBonLivraison.get();
            bonLivraisonRepository.delete(bonLivraison);
        } else {
              throw new RuntimeException("BonLivraison with id " + id + " not found");
        }
    }

    @Override
    public List<BonLivraisonDTO> listBonLivraisonsDTO() {
        List<BonLivraison> bonLivraisons = bonLivraisonRepository.findAll();
        return bonLivraisons.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private BonLivraisonDTO convertToDto(BonLivraison bonLivraison) {
        return BonLivraisonDTO.builder()
                .codeSapBL(bonLivraison.getCodeSapBL())
                .documentBL(bonLivraison.getDocumentBL())
                .dateReception(bonLivraison.getDateReception())
                .idRecepteur(bonLivraison.getIdRecepteur())
                .status(bonLivraison.getStatus())
                .build();
    }

    @Override
    public List<BonLivraison> listBonLivraisons() {
        return bonLivraisonRepository.findAll();
    }

    @Override
    public BonLivraison loadBonLivraisonById(Long id) {
        Optional<BonLivraison> bonLivraisonOptional = bonLivraisonRepository.findById(id);
        return bonLivraisonOptional.orElse(null);
    }

    public BonLivraisonDTO loadBonLivraisonDTOById(Long id) {
        Optional<BonLivraison> bonLivraisonOptional = bonLivraisonRepository.findById(id);
        if (bonLivraisonOptional.isPresent()) {
            BonLivraison bonLivraison = bonLivraisonOptional.get();
            return convertToDto(bonLivraison);
        } else {
            return null;
        }
    }

    @Override
    public BonLivraison loadBonLivraisonByCodeSap(Long codeSapBL) {
            Optional<BonLivraison> bonLivraisonOptional = Optional.ofNullable(bonLivraisonRepository.findByCodeSapBL(codeSapBL));
            return bonLivraisonOptional.orElse(null);
    }


//    @Override
//    public BonLivraison updateBonLivraisonByCodeSapBL(Long codeSapBL, BonLivraison updatedBonLivraison) {
//        BonLivraison existingBonLivraison = bonLivraisonRepository.findByCodeSapBL(codeSapBL);
//        if (existingBonLivraison != null) {
//            return bonLivraisonRepository.save(existingBonLivraison);
//        } else {
//            throw new IllegalArgumentException("Bon de Livraison non trouvé avec le codeSapBL : " + codeSapBL);
//        }
//    }
//
//    @Override
//    public void deleteBonLivraisonByCodeSapBL(Long codeSapBL) {
//        BonLivraison existingBonLivraison = bonLivraisonRepository.findByCodeSapBL(codeSapBL);
//        if (existingBonLivraison != null) {
//            bonLivraisonRepository.delete(existingBonLivraison);
//        } else {
//            throw new IllegalArgumentException("Bon de Livraison non trouvé avec le codeSapBL : " + codeSapBL);
//        }
//    }
//
//    @Override
//    public BonLivraison getBonLivraisonByCodeSapBL(Long codeSapBL) {
//        BonLivraison bonLivraison = bonLivraisonRepository.findByCodeSapBL(codeSapBL);
//        if (bonLivraison == null) {
//            throw new IllegalArgumentException("Bon de Livraison non trouvé avec le codeSapBL : " + codeSapBL);
//        }
//        return bonLivraison;
//    }
//
//    @Override
//    public Page<BonLivraison> getAllBonLivraisonByPage(int page, int size) {
//        try {
//            return bonLivraisonRepository.findAll(PageRequest.of(page, size));
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération des bons de livraison par page : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public BonLivraison saveBonLivraison(BonLivraison bonLivraison) {
//        try {
//
//            if (bonLivraison.getFournisseur() == null) {
//                throw new IllegalArgumentException("Le fournisseur du bon de livraison ne peut pas être null.");
//            }
//            BonLivraison savedBonLivraison = bonLivraisonRepository.save(bonLivraison);
//            bonLivraisonRepository.updateStockDisponibleByBonLivraison(savedBonLivraison);
//            return savedBonLivraison;
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de l'enregistrement du bon de livraison : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public BonLivraison updateBonLivraison(BonLivraison bonLivraison) {
//        try {
//            if (bonLivraisonRepository.existsById(bonLivraison.getIdBL())) {
//                return bonLivraisonRepository.save(bonLivraison);
//            } else {
//                throw new IllegalArgumentException("Bon de livraison non trouvé avec l'identifiant : " + bonLivraison.getIdBL());
//            }
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la mise à jour du bon de livraison : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public BonLivraison getBonLivraisonById(Long idBL) {
//        try {
//            return bonLivraisonRepository.findById(idBL)
//                    .orElseThrow(() -> new IllegalArgumentException("Bon de livraison non trouvé avec l'identifiant : " + idBL));
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération du bon de livraison par ID : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public List<BonLivraison> getAllBonLivraison() {
//        try {
//            return bonLivraisonRepository.findAll();
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération de tous les bons de livraison : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public void deleteBonLivraisonById(Long idBL) {
//        try {
//            bonLivraisonRepository.deleteById(idBL);
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la suppression du bon de livraison par ID : " + e.getMessage());
//        }
//    }

}



