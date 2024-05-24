package org.gmaoback.gmaomondi_backend.gestionStock.services.impl;

import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.User;
import org.gmaoback.gmaomondi_backend.gestionStock.dao.repositories.UserRepository;
import org.gmaoback.gmaomondi_backend.gestionStock.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de l'enregistrement de l'utilisateur : " + e.getMessage());
        }
    }

    @Override
    public User updateUser(User user) {
        try {
            if (userRepository.existsById(user.getIdUser())) {
                return userRepository.save(user);
            } else {
                throw new IllegalArgumentException("Utilisateur non trouvé avec l'identifiant : " + user.getIdUser());
            }
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la mise à jour de l'utilisateur : " + e.getMessage());
        }
    }

    @Override
    public User getUserById(Long idUser) {
        try {
            return userRepository.findById(idUser)
                    .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé avec l'identifiant : " + idUser));
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération de l'utilisateur par ID : " + e.getMessage());
        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération de tous les utilisateurs : " + e.getMessage());
        }
    }

    @Override
    public void deleteUserById(Long idUser) {
        try {
            userRepository.deleteById(idUser);
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la suppression de l'utilisateur par ID : " + e.getMessage());
        }
    }

    @Override
    public Page<User> getAllUsersByPage(int page, int size) {
        try {
            return userRepository.findAll(PageRequest.of(page, size));
        } catch (Exception e) {
            throw new IllegalStateException("Erreur lors de la récupération des utilisateurs par page : " + e.getMessage());
        }
    }
}
