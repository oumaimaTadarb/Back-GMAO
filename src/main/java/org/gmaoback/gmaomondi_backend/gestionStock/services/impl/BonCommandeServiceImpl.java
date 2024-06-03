package org.gmaoback.gmaomondi_backend.gestionStock.services.impl;

import jakarta.persistence.EntityNotFoundException;
import org.gmaoback.gmaomondi_backend.gestionFournisseur.dao.entitites.Fournisseur;
import org.gmaoback.gmaomondi_backend.gestionFournisseur.dao.repository.FournisseurRepository;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.BonCommande;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories.BonCommandeRepository;
import org.gmaoback.gmaomondi_backend.gestionStock.services.dto.BonCommandeDTO;
import org.gmaoback.gmaomondi_backend.gestionStock.services.service.BonCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BonCommandeServiceImpl implements BonCommandeService {

    @Autowired
    private BonCommandeRepository bonCommandeRepository;
    @Autowired
    private FournisseurRepository fournisseurRepository;
    @Override
    public BonCommande addNewBonCommande(BonCommandeDTO bonCommandeDto) {
        BonCommande bonCommande = new BonCommande();
        bonCommande.setCodeSapBC(bonCommandeDto.getCodeSapBC());
        bonCommande.setDateBC(LocalDateTime.now());
        bonCommande.setDocumentBC(bonCommandeDto.getDocumentBC());
        bonCommande.setMontant(bonCommandeDto.getMontant());
        bonCommande.setDateLivraisonConfirmee(bonCommandeDto.getDateLivraisonConfirmee());
        bonCommande.setDateDemissionProforma(bonCommandeDto.getDateDemissionProforma());
        bonCommande.setNumProforma(bonCommandeDto.getNumProforma());
        bonCommande.setDocProforma(bonCommandeDto.getDocProforma());
        bonCommande.setPrixUnitaire(bonCommandeDto.getPrixUnitaire());
        Fournisseur fournisseur = fournisseurRepository.findById(bonCommandeDto.getIdFournisseur()).orElse(null);
        if (fournisseur == null) {
            System.err.println("Erreur: Fournisseur non trouvé.");
            return null;
        } else {
            bonCommande.setFournisseur(fournisseur);
        }
        return bonCommandeRepository.save(bonCommande);
    }

    @Override
    public BonCommande updateBonCommande(Long id, BonCommandeDTO bonCommandeDTO) {
        Optional<BonCommande> bonCommandeOptional = bonCommandeRepository.findById(id);
        if (bonCommandeOptional.isPresent()) {
            BonCommande bonCommande = bonCommandeOptional.get();
            bonCommande.setCodeSapBC(bonCommandeDTO.getCodeSapBC());
            bonCommande.setDateBC(LocalDateTime.now());
            bonCommande.setDocumentBC(bonCommandeDTO.getDocumentBC());
            bonCommande.setMontant(bonCommandeDTO.getMontant());
            bonCommande.setDateLivraisonConfirmee(bonCommandeDTO.getDateLivraisonConfirmee());
            bonCommande.setDateDemissionProforma(bonCommandeDTO.getDateDemissionProforma());
            bonCommande.setNumProforma(bonCommandeDTO.getNumProforma());
            bonCommande.setDocProforma(bonCommandeDTO.getDocProforma());
            bonCommande.setPrixUnitaire(bonCommandeDTO.getPrixUnitaire());
            Fournisseur fournisseur = fournisseurRepository.findById(bonCommandeDTO.getIdFournisseur()).orElse(null);
            if (fournisseur == null) {
                System.err.println("Erreur: Fournisseur non trouvé.");
                return null;
            } else {
                bonCommande.setFournisseur(fournisseur);
            }
            return bonCommandeRepository.save(bonCommande);
        } else {
            System.err.println("Erreur: Bon de commande non trouvé.");
            return null;
        }
    }

    @Override
    public BonCommande updateData(BonCommande bonCommande, BonCommandeDTO bonCommandeDto) {
        bonCommande.setCodeSapBC(bonCommandeDto.getCodeSapBC());
            bonCommande.setDateBC(LocalDateTime.now());
            bonCommande.setDocumentBC(bonCommandeDto.getDocumentBC());
            bonCommande.setMontant(bonCommandeDto.getMontant());
            bonCommande.setDateLivraisonConfirmee(bonCommandeDto.getDateLivraisonConfirmee());
            bonCommande.setDateDemissionProforma(bonCommandeDto.getDateDemissionProforma());
            bonCommande.setNumProforma(bonCommandeDto.getNumProforma());
            bonCommande.setDocProforma(bonCommandeDto.getDocProforma());
            bonCommande.setPrixUnitaire(bonCommandeDto.getPrixUnitaire());


            Fournisseur fournisseur = fournisseurRepository.findById(bonCommandeDto.getIdFournisseur()).orElse(null);
            if (fournisseur == null) {
                System.err.println("Erreur: Fournisseur non trouvé.");
                return null;
            } else {
                bonCommande.setFournisseur(fournisseur);
            }

            return bonCommande;
        }



    @Override
    public void deleteBonCommande(Long id) {
        bonCommandeRepository.deleteById(id);
        Optional<BonCommande> optionalBonCommande = bonCommandeRepository.findById(id);
        if (optionalBonCommande.isPresent()) {
            throw new EntityNotFoundException("BonCommande non supprimé");

        }
    }

    @Override
    public List<BonCommande> listBonCommandes() {
        return this.bonCommandeRepository.findAll();
    }

    @Override
    public BonCommande loadBonCommandeById(Long id) {
        return bonCommandeRepository.findById(id).orElse(null);

    }

    @Override
    public BonCommande loadBonCommandeByCodeSap(Long codeSapBC) {
        return bonCommandeRepository.findByCodeSapBC(codeSapBC);
    }
    @Override
    public List<BonCommandeDTO> listBonCommandesDTO() {
        List<BonCommande> bonCommandes = bonCommandeRepository.findAll();
        List<BonCommandeDTO> bonCommandesDTO = new ArrayList<>();

        for (BonCommande bonCommande : bonCommandes) {
            BonCommandeDTO bonCommandeDTO = new BonCommandeDTO();
            bonCommandeDTO.setCodeSapBC(bonCommande.getCodeSapBC());
            bonCommandeDTO.setDateBC(Date.from(bonCommande.getDateBC().atZone(ZoneId.systemDefault()).toInstant()));
            bonCommandeDTO.setDocumentBC(bonCommande.getDocumentBC());
            bonCommandeDTO.setMontant(bonCommande.getMontant());
            bonCommandeDTO.setDateLivraisonConfirmee(bonCommande.getDateLivraisonConfirmee());
            bonCommandeDTO.setDateDemissionProforma(bonCommande.getDateDemissionProforma());
            bonCommandeDTO.setNumProforma(bonCommande.getNumProforma());
            bonCommandeDTO.setDocProforma(bonCommande.getDocProforma());
            bonCommande.setPrixUnitaire(bonCommande.getPrixUnitaire());
            bonCommandeDTO.setIdFournisseur(bonCommande.getFournisseur().getIdFournisseur());

            bonCommandesDTO.add(bonCommandeDTO);
        }

        return bonCommandesDTO;
    }


    @Override
    public BonCommandeDTO loadBonCommandeByBonCommandeId(Long id) {
        Optional<BonCommande> bonCommandeOptional = bonCommandeRepository.findById(id);
        if (bonCommandeOptional.isPresent()) {
            BonCommande bonCommande = bonCommandeOptional.get();

            BonCommandeDTO bonCommandeDTO = new BonCommandeDTO();
            bonCommandeDTO.setCodeSapBC(bonCommande.getCodeSapBC());
            bonCommandeDTO.setDateBC(Date.from(bonCommande.getDateBC().atZone(ZoneId.systemDefault()).toInstant()));
            bonCommandeDTO.setDocumentBC(bonCommande.getDocumentBC());
            bonCommandeDTO.setMontant(bonCommande.getMontant());
            bonCommandeDTO.setDateLivraisonConfirmee(bonCommande.getDateLivraisonConfirmee());
            bonCommandeDTO.setDateDemissionProforma(bonCommande.getDateDemissionProforma());
            bonCommandeDTO.setNumProforma(bonCommande.getNumProforma());
            bonCommandeDTO.setDocProforma(bonCommande.getDocProforma());
            bonCommande.setPrixUnitaire(bonCommande.getPrixUnitaire());
            bonCommandeDTO.setIdFournisseur(bonCommande.getFournisseur().getIdFournisseur());


            return bonCommandeDTO;
        } else {
            throw new IllegalArgumentException("Identifiant de bon de commande invalide : " + id);
        }
    }



}
//    @Override
//    @Transactional
//    public BonCommande updateBonCommandeByCodeSapBC(Long codeSapBC, BonCommande updatedBonCommande) {
//        BonCommande existingBonCommande = bonCommandeRepository.findByCodeSapBC(codeSapBC);
//        if (existingBonCommande != null) {
//            return bonCommandeRepository.save(existingBonCommande);
//        } else {
//            throw new IllegalArgumentException("Bon de commande non trouvé avec le codeSapBC : " + codeSapBC);
//        }
//    }
//
//    @Override
//    @Transactional
//    public void deleteBonCommandeByCodeSapBC(Long codeSapBC) {
//        BonCommande existingBonCommande = bonCommandeRepository.findByCodeSapBC(codeSapBC);
//        if (existingBonCommande != null) {
//            bonCommandeRepository.delete(existingBonCommande);
//        } else {
//            throw new IllegalArgumentException("Bon de commande non trouvé avec le codeSapBC : " + codeSapBC);
//        }
//    }
//
//    @Override
//    public Page<BonCommande> getAllBonCommandesByPage(int page, int size) {
//        try {
//            return bonCommandeRepository.findAll(PageRequest.of(page, size));
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération des bons de commande par page : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public BonCommande getBonCommandeByCodeSapBC(Long codeSapBC) {
//        try {
//            BonCommande bonCommande = bonCommandeRepository.findByCodeSapBC(codeSapBC);
//            if (bonCommande == null) {
//                throw new IllegalArgumentException("Bon de commande non trouvé avec le codeSapBC : " + codeSapBC);
//            }
//            return bonCommande;
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération du bon de commande par codeSapBC : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public BonCommande saveBonCommande(BonCommande bonCommande) {
//        try {
//            return bonCommandeRepository.save(bonCommande);
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de l'enregistrement du bon de commande : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public BonCommande updateBonCommande(BonCommande bonCommande) {
//        try {
//            if (bonCommandeRepository.existsById(bonCommande.getIdBC())) {
//                return bonCommandeRepository.save(bonCommande);
//            } else {
//                throw new IllegalArgumentException("Bon de commande non trouvé avec l'identifiant : " + bonCommande.getIdBC());
//            }
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la mise à jour du bon de commande : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public BonCommande getBonCommandeById(Long idBC) {
//        try {
//            return bonCommandeRepository.findById(idBC)
//                    .orElseThrow(() -> new IllegalArgumentException("Bon de commande non trouvé avec l'identifiant : " + idBC));
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération du bon de commande par ID : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public void deleteBonCommandeById(Long idBC) {
//        try {
//            bonCommandeRepository.deleteById(idBC);
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la suppression du bon de commande par ID : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public List<BonCommande> getAllBonCommandes() {
//        try {
//            return bonCommandeRepository.findAll();
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération de tous les bons de commande : " + e.getMessage());
//        }
//    }
//}
