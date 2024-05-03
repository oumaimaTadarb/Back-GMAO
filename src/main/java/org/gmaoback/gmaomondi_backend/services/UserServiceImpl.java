package org.gmaoback.gmaomondi_backend.services;

import org.gmaoback.gmaomondi_backend.dao.entites.User;
import org.gmaoback.gmaomondi_backend.dao.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

//    @Override
//    public User saveUser(User user) {
//        return userRepository.save(user);
//    }
//
//    @Override
//    public User updateUser(User user) {
//        if (userRepository.existsById(user.getIdUser())) {
//            return userRepository.save(user);
//        } else {
//            throw new IllegalArgumentException("Utilisateur non trouvé avec l'identifiant : " + user.getIdUser());
//        }
//    }
//
//    @Override
//    public User getUserById(Long idUser) {
//        return userRepository.findById(idUser)
//                .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé avec l'identifiant : " + idUser));
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    @Override
//    public void deleteUserById(Long idUser) {
//        userRepository.deleteById(idUser);
//    }

    @Override
    public Page<User> getAllUsersByPage(int page, int size) {
        return userRepository.findAll(PageRequest.of(page, size));
    }
}
