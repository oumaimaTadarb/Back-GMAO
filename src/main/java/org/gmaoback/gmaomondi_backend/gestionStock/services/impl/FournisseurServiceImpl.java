package org.gmaoback.gmaomondi_backend.gestionStock.services.impl;

import jakarta.persistence.EntityNotFoundException;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.Fournisseur;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories.FournisseurRepository;
import org.gmaoback.gmaomondi_backend.gestionStock.dto.FournisseurDTO;
import org.gmaoback.gmaomondi_backend.gestionStock.services.FournisseurService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FournisseurServiceImpl implements FournisseurService {

    private final FournisseurRepository fournisseurRepository;

    public FournisseurServiceImpl(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    @Override
    public Fournisseur addNewFournisseur(FournisseurDTO fournisseurDto) {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setCodeSapFr(fournisseurDto.getCodeSapFr());
        fournisseur.setNom(fournisseurDto.getNom());
        fournisseur.setTel(fournisseurDto.getTel());
        fournisseur.setEmail(fournisseurDto.getEmail());
        fournisseur.setAdresse(fournisseurDto.getAdresse());
        return fournisseurRepository.save(fournisseur);

    }

    @Override
    public Fournisseur updateFournisseur(Long id, FournisseurDTO fournisseurDTO) {
        Fournisseur fournisseur = fournisseurRepository.findById(id).orElse(null);
        if (fournisseur != null) {
            fournisseur.setCodeSapFr(fournisseurDTO.getCodeSapFr());
            fournisseur.setNom(fournisseurDTO.getNom());
            fournisseur.setTel(fournisseurDTO.getTel());
            fournisseur.setEmail(fournisseurDTO.getEmail());
            fournisseur.setAdresse(fournisseurDTO.getAdresse());

            return fournisseurRepository.save(fournisseur);
        }
        return null;
    }

    @Override
    public Fournisseur updateData(Fournisseur fournisseur, FournisseurDTO fournisseurDto) {

            fournisseur.setCodeSapFr(fournisseurDto.getCodeSapFr());
            fournisseur.setNom(fournisseurDto.getNom());
            fournisseur.setTel(fournisseurDto.getTel());
            fournisseur.setEmail(fournisseurDto.getEmail());
            fournisseur.setAdresse(fournisseurDto.getAdresse());

            return fournisseur;
    }




@Override
    public void deleteFournisseur(Long id) {
    fournisseurRepository.deleteById(id);

    Fournisseur fournisseur = fournisseurRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Fournisseur non trouvé " ));
    fournisseurRepository.delete(fournisseur);
    }



    @Override
    public List<FournisseurDTO> listFournisseursDTO() {
        List<Fournisseur> fournisseurs = fournisseurRepository.findAll();
        List<FournisseurDTO> fournisseursDTO = fournisseurs.stream()
                .map(this::convertToFournisseurDTO)
                .collect(Collectors.toList());
        return fournisseursDTO;
    }

    public FournisseurDTO convertToFournisseurDTO(Fournisseur fournisseur) {
        if (fournisseur == null) {
            return null;
        }
        FournisseurDTO fournisseurDto = new FournisseurDTO();
        fournisseurDto.setIdFournisseur(fournisseur.getIdFournisseur());
        fournisseurDto.setCodeSapFr(fournisseur.getCodeSapFr());
        fournisseurDto.setNom(fournisseur.getNom());
        fournisseurDto.setTel(fournisseur.getTel());
        fournisseurDto.setEmail(fournisseur.getEmail());
        fournisseurDto.setAdresse(fournisseur.getAdresse());
        // Ajoutez d'autres attributs si nécessaire

        return fournisseurDto;
    }


    @Override
    public List<Fournisseur> listFournisseurs() {
        return this.fournisseurRepository.findAll();
    }

    @Override
    public Fournisseur loadFournisseurById(Long id) {
        return fournisseurRepository.findById(id).orElse(null);
    }

    @Override
    public FournisseurDTO loadFournisseurByFournisseurId(Long id) {
        return null;
    }

    @Override
    public Fournisseur loadFournisseurBycodeSapFr(Long codeSapFr) {
        return this.fournisseurRepository.findBycodeSapFr(codeSapFr);
    }
//
//    @Override
//    public Fournisseur saveFournisseur(Fournisseur fournisseur) {
//        try {
//            return fournisseurRepository.save(fournisseur);
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de l'enregistrement du fournisseur : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public Fournisseur updateFournisseur(Fournisseur fournisseur) {
//        try {
//            if (fournisseurRepository.existsById(fournisseur.getIdFournisseur())) {
//                return fournisseurRepository.save(fournisseur);
//            } else {
//                throw new IllegalArgumentException("Fournisseur non trouvé avec l'identifiant : " + fournisseur.getIdFournisseur());
//            }
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la mise à jour du fournisseur : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public Fournisseur getFournisseurById(Long idFournisseur) {
//        try {
//            return fournisseurRepository.findById(idFournisseur)
//                    .orElseThrow(() -> new IllegalArgumentException("Fournisseur non trouvé avec l'identifiant : " + idFournisseur));
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération du fournisseur par ID : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public void deleteFournisseurById(Long idFournisseur) {
//        try {
//            fournisseurRepository.deleteById(idFournisseur);
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la suppression du fournisseur par ID : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public List<Fournisseur> getAllFournisseurs() {
//        try {
//            return fournisseurRepository.findAll();
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération de tous les fournisseurs : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public Fournisseur getFournisseurBycodeSapFr(Long codeSapFr) {
//        try {
//            return fournisseurRepository.findBycodeSapFr(codeSapFr);
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération du fournisseur par codeSapFr : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public Fournisseur updateFournisseurByCodeSapFr(Long codeSapFr, Fournisseur updatedFournisseur) {
//        try {
//            Fournisseur existingFournisseur = fournisseurRepository.findBycodeSapFr(codeSapFr);
//            if (existingFournisseur != null) {
//                return fournisseurRepository.save(existingFournisseur);
//            } else {
//                throw new IllegalArgumentException("Fournisseur non trouvé avec le codeSapFr : " + codeSapFr);
//            }
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la mise à jour du fournisseur par codeSapFr : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public void deleteFournisseurByCodeSapFr(Long codeSapFr) {
//        try {
//            Fournisseur existingFournisseur = fournisseurRepository.findBycodeSapFr(codeSapFr);
//            if (existingFournisseur != null) {
//                fournisseurRepository.delete(existingFournisseur);
//            } else {
//                throw new IllegalArgumentException("Fournisseur non trouvé avec le codeSapFr : " + codeSapFr);
//            }
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la suppression du fournisseur par codeSapFr : " + e.getMessage());
//        }
//    }
}
