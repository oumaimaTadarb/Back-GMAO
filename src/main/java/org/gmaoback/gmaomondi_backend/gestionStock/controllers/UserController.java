package org.gmaoback.gmaomondi_backend.gestionStock.controllers;

import org.gmaoback.gmaomondi_backend.gestionStock.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;
//    @GetMapping("/page")
//    public Page<User> getAllUsersByPage(@RequestParam("page") int page, @RequestParam("size") int size) {
//        return userService.getAllUsersByPage(page, size);
//    }
//
//    @PostMapping("/saveUser")
//    public User saveUser(@RequestBody User user) {
//        return userService.saveUser(user);
//    }
//
//    @PutMapping("/{id}")
//    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
//        user.setIdUser(id); // Assurez-vous que l'ID de l'utilisateur est défini
//        return userService.updateUser(user);
//    }
//
//    @GetMapping("/{id}")
//    public User getUserById(@PathVariable("id") Long id) {
//        return userService.getUserById(id);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteUserById(@PathVariable("id") Long id) {
//        userService.deleteUserById(id);
//    }
//
//    @GetMapping
//    public List<User> getAllUsers() {
//        return userService.getAllUsers();
//    }
//

}

