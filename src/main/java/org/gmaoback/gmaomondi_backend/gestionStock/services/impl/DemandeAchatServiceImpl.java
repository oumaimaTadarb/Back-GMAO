package org.gmaoback.gmaomondi_backend.gestionStock.services.impl;

import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.DemandeAchat;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories.DemandeAchatRepository;
import org.gmaoback.gmaomondi_backend.gestionStock.dto.DemandeAchatDTO;
import org.gmaoback.gmaomondi_backend.gestionStock.services.DemandeAchatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DemandeAchatServiceImpl implements DemandeAchatService {

    @Autowired
    private DemandeAchatRepository demandeAchatRepository;

    @Override
    public DemandeAchat addNewDemandeAchat(DemandeAchatDTO demandeAchatDto) {
        DemandeAchat demandeAchat = new DemandeAchat();
        demandeAchat.setCodeSapDA(demandeAchatDto.getCodeSapDA());
        demandeAchat.setDateDA(LocalDateTime.now());
        demandeAchat.setCommentaire(demandeAchatDto.getCommentaire());
        demandeAchat.setDateSouhaitee(demandeAchatDto.getDateSouhaitee());
        demandeAchat.setDateDemissionDevis(demandeAchatDto.getDateDemissionDevis());
        demandeAchat.setNumDevis(demandeAchatDto.getNumDevis());
        demandeAchat.setDocDevis(demandeAchatDto.getDocDevis());
        demandeAchat.setType(demandeAchatDto.getType());

        return demandeAchatRepository.save(demandeAchat);
    }

    @Override
    public DemandeAchat updateData(DemandeAchat demandeAchat, DemandeAchatDTO demandeAchatDto) {
        if (demandeAchat == null || demandeAchatDto == null) {
            return null; // Ou vous pouvez jeter une exception
        }

        // Mettez à jour les champs de demandeAchat avec les valeurs de demandeAchatDto
        // Assurez-vous de ne mettre à jour que les champs non null dans le DTO

        if (demandeAchatDto.getCodeSapDA() != null) {
            demandeAchat.setCodeSapDA(demandeAchatDto.getCodeSapDA());
        }

        if (demandeAchatDto.getDateSouhaitee() != null) {
            demandeAchat.setDateSouhaitee(demandeAchatDto.getDateSouhaitee());
        }

        if (demandeAchatDto.getCommentaire() != null) {
            demandeAchat.setCommentaire(demandeAchatDto.getCommentaire());
        }

        if (demandeAchatDto.getDateDA() != null) {
            demandeAchat.setDateDA(demandeAchatDto.getDateDA());
        }

        if (demandeAchatDto.getDateDemissionDevis() != null) {
            demandeAchat.setDateDemissionDevis(demandeAchatDto.getDateDemissionDevis());
        }

        if (demandeAchatDto.getNumDevis() != 0) {
            demandeAchat.setNumDevis(demandeAchatDto.getNumDevis());
        }

        if (demandeAchatDto.getDocDevis() != null) {
            demandeAchat.setDocDevis(demandeAchatDto.getDocDevis());
        }

        if (demandeAchatDto.getType() != null) {
            demandeAchat.setType(demandeAchatDto.getType());
        }
        return demandeAchat;
    }


    @Override
    public void deleteDemandeAchat(Long id) {
        if (id == null) {
        throw new IllegalArgumentException("L'identifiant de la demande d'achat ne peut pas être null");
    }
        demandeAchatRepository.deleteById(id);


    }

    @Override
    public List<DemandeAchatDTO> listDemandeAchatsDTO() {
        List<DemandeAchat> demandeAchats = demandeAchatRepository.findAll();
        List<DemandeAchatDTO> demandeAchatsDTO = new ArrayList<>();
        for (DemandeAchat demandeAchat : demandeAchats) {
            DemandeAchatDTO demandeAchatDTO = new DemandeAchatDTO();
            demandeAchatDTO.setIdDA(demandeAchat.getIdDA());
            demandeAchatDTO.setCodeSapDA(demandeAchat.getCodeSapDA());
            demandeAchatDTO.setDateSouhaitee(demandeAchat.getDateSouhaitee());
            demandeAchatDTO.setCommentaire(demandeAchat.getCommentaire());
            demandeAchatDTO.setDateDA(demandeAchat.getDateDA());
            demandeAchatDTO.setDateDemissionDevis(demandeAchat.getDateDemissionDevis());
            demandeAchatDTO.setNumDevis(demandeAchat.getNumDevis());
            demandeAchatDTO.setDocDevis(demandeAchat.getDocDevis());
            demandeAchatDTO.setType(demandeAchat.getType());

            demandeAchatsDTO.add(demandeAchatDTO);
        }

        return demandeAchatsDTO;
    }


    @Override
    public List<DemandeAchat> listDemandeAchats() {
        return demandeAchatRepository.findAll();
    }

    @Override
    public DemandeAchat loadDemandeAchatById(Long id) {
         Optional<DemandeAchat> demandeAchatOptional = demandeAchatRepository.findById(id);
        return demandeAchatOptional.orElse(null);
    }

    @Override
    public DemandeAchatDTO loadDemandeAchatByDemandeAchatId(Long id) {
        DemandeAchat demandeAchat = loadDemandeAchatById(id);
        if (demandeAchat != null) {
            DemandeAchatDTO demandeAchatDTO = new DemandeAchatDTO();
            demandeAchatDTO.setIdDA(demandeAchat.getIdDA());
            demandeAchatDTO.setCodeSapDA(demandeAchat.getCodeSapDA());
            demandeAchatDTO.setDateSouhaitee(demandeAchat.getDateSouhaitee());
            demandeAchatDTO.setCommentaire(demandeAchat.getCommentaire());
            demandeAchatDTO.setDateDA(demandeAchat.getDateDA());
            demandeAchatDTO.setDateDemissionDevis(demandeAchat.getDateDemissionDevis());
            demandeAchatDTO.setNumDevis(demandeAchat.getNumDevis());
            demandeAchatDTO.setDocDevis(demandeAchat.getDocDevis());
            demandeAchatDTO.setType(demandeAchat.getType());
            return demandeAchatDTO;
        }
        return null;
    }

    @Override
    public DemandeAchat loadDemandeAchatByCodeSap(Long codeSapDA) {
        return demandeAchatRepository.findByCodeSapDA(codeSapDA);
    }

    @Override
    public DemandeAchat updateDemandeAchat(Long id, DemandeAchatDTO demandeAchatDTO) {
         DemandeAchat demandeAchat = loadDemandeAchatById(id);
        if (demandeAchat != null && demandeAchatDTO != null) {
            demandeAchat = updateData(demandeAchat, demandeAchatDTO);
            return demandeAchatRepository.save(demandeAchat);
        }
        return null;
    }

    @Override
    public DemandeAchat updateDemandeAchatByCodeSapDA(Long codeSapDA, DemandeAchatDTO demandeAchatDTO) {
        DemandeAchat demandeAchat = loadDemandeAchatByCodeSap(codeSapDA);
        if (demandeAchat != null && demandeAchatDTO != null) {
             demandeAchat = updateData(demandeAchat, demandeAchatDTO);
           return demandeAchatRepository.save(demandeAchat);
        }
        return null;
    }
//    @Override
//    public DemandeAchat findDevisByCodeSapDA(Long codeSapDA) {
//        try {
//            DemandeAchat demandeAchat = demandeAchatRepository.findDevisByCodeSapDA(codeSapDA);
//            if (demandeAchat == null) {
//                throw new IllegalArgumentException("Devis non trouvé avec le codeSapDA : " + codeSapDA);
//            }
//            return demandeAchat;
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération du devis par codeSapDA : " + e.getMessage());
//        }
//    }

}
//    @Override
//    @Transactional
//    public DemandeAchat updateDemandeAchatByCodeSapDA(Long codeSapDA, DemandeAchat updatedDemandeAchat) {
//        DemandeAchat existingDemandeAchat = demandeAchatRepository.findByCodeSapDA(codeSapDA);
//        if (existingDemandeAchat != null) {
//            return demandeAchatRepository.save(existingDemandeAchat);
//        } else {
//            throw new IllegalArgumentException("Demande d'achat non trouvée avec le codeSapDA : " + codeSapDA);
//        }
//    }
//
//    @Override
//    @Transactional
//    public void deleteDemandeAchatByCodeSapDA(Long codeSapDA) {
//        DemandeAchat existingDemandeAchat = demandeAchatRepository.findByCodeSapDA(codeSapDA);
//        if (existingDemandeAchat != null) {
//            demandeAchatRepository.delete(existingDemandeAchat);
//        } else {
//            throw new IllegalArgumentException("Demande d'achat non trouvée avec le codeSapDA : " + codeSapDA);
//        }
//    }
//
//    @Override
//    public Page<DemandeAchat> getAllDemandeAchatByPage(int page, int size) {
//        try {
//            return demandeAchatRepository.findAll(PageRequest.of(page, size));
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération des demandes d'achat par page : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public DemandeAchat getDemandeAchatBycodeSapDA(Long codeSapDA) {
//        try {
//            DemandeAchat demandeAchat = demandeAchatRepository.findByCodeSapDA(codeSapDA);
//            if (demandeAchat == null) {
//                throw new IllegalArgumentException("Demande d'achat non trouvée avec le codeSapDA : " + codeSapDA);
//            }
//            return demandeAchat;
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération de la demande d'achat par codeSapDA : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public DemandeAchat findDevisByCodeSapDA(Long codeSapDA) {
//        try {
//            DemandeAchat demandeAchat = demandeAchatRepository.findDevisByCodeSapDA(codeSapDA);
//            if (demandeAchat == null) {
//                throw new IllegalArgumentException("Devis non trouvé avec le codeSapDA : " + codeSapDA);
//            }
//            return demandeAchat;
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération du devis par codeSapDA : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public DemandeAchat saveDemandeAchat(DemandeAchat demandeAchat) {
//        try {
//            return demandeAchatRepository.save(demandeAchat);
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de l'enregistrement de la demande d'achat : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public DemandeAchat updateDemandeAchat(DemandeAchat demandeAchat) {
//        try {
//            if (demandeAchatRepository.existsById(demandeAchat.getIdDA())) {
//                return demandeAchatRepository.save(demandeAchat);
//            } else {
//                throw new IllegalArgumentException("Demande d'achat non trouvée avec l'identifiant : " + demandeAchat.getIdDA());
//            }
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la mise à jour de la demande d'achat : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public DemandeAchat getDemandeAchatById(Long idDa) {
//        try {
//            return demandeAchatRepository.findById(idDa)
//                    .orElseThrow(() -> new IllegalArgumentException("Demande d'achat non trouvée avec l'identifiant : " + idDa));
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération de la demande d'achat par ID : " + e.getMessage());
//        }
//    }
//
//    @Override
//    public List<DemandeAchat> getAllDemandeAchat() {
//        try {
//            return demandeAchatRepository.findAll();
//        } catch (Exception e) {
//            throw new IllegalStateException("Erreur lors de la récupération de toutes les demandes d'achat : " + e.getMessage());
//        }
//    }

