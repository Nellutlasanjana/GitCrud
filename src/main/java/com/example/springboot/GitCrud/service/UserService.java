package com.example.springboot.GitCrud.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.GitCrud.Entity.User;
import com.example.springboot.GitCrud.Exceptions.ResourceNotFoundException;
import com.example.springboot.GitCrud.repository.UserRepository;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        logger.debug("Saving user: {}", user);
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser) {
        logger.debug("Updating user ID {} with data: {}", id, updatedUser);
        User user = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setStatus(updatedUser.getStatus());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        logger.debug("Deleting user ID {}", id);
        userRepository.deleteById(id);
    }

    public List<User> getAllUsers() {
        logger.debug("Retrieving all users");
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        logger.debug("Retrieving user ID {}", id);
        return userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));
    }
}
