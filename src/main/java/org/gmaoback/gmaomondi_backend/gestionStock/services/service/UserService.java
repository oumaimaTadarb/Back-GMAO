package org.gmaoback.gmaomondi_backend.gestionStock.services.service;

import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User updateUser(User user);
    User getUserById(Long idUser);
    List<User> getAllUsers();
    void deleteUserById(Long idUser);
    Page<User> getAllUsersByPage(int page, int size);
}
