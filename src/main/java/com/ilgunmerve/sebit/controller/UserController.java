package com.ilgunmerve.sebit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ilgunmerve.sebit.dao.UserDAO;
import com.ilgunmerve.sebit.model.User;

@RestController
public class UserController {

	@Autowired    
    UserDAO userDAO;  

    @GetMapping("/users")
    List<User> findAll() {
        return userDAO.listUser();
    }
    
    @PostMapping("/users")
    int newUser(@RequestBody User newUser) {
        return userDAO.save(newUser);
    }
    
 // Find
    @GetMapping("/users/{id}")
    Optional<User> findOne(@PathVariable int id) {
        return userDAO.get(id);
    }

    // Save or update
    @PutMapping("/users/{id}")
    int saveOrUpdate(@RequestBody User newUser, @PathVariable int id) {

        return userDAO.get(id)
                .map(x -> {
                    x.setName(newUser.getName());
                    x.setSurname(newUser.getSurname());
                    x.setSalary(newUser.getSalary());
                    x.setUserId(id);
                    return userDAO.update(x);
                })
                .orElseGet(() -> {
                    newUser.setUserId(id);
                    return userDAO.save(newUser);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable int id) {
        userDAO.delete(id);
    }

}
