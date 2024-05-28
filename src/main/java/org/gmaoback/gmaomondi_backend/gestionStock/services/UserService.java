package org.gmaoback.gmaomondi_backend.gestionStock.services;

import org.gmaoback.gmaomondi_backend.gestionStock.dao.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User updateUser(User user);
    User getUserById(Long idUser);
    List<User> getAllUsers();
    void deleteUserById(Long idUser);
    Page<User> getAllUsersByPage(int page, int size);
}
