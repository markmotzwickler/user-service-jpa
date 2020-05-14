package com.example.userservicejpa.service;

import com.example.userservicejpa.model.User;
import com.example.userservicejpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return getAllUsers()
                .stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElseGet(User::new);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public Iterable<String> getAllUsernames() {
        return userRepository.findAllUsernames();
    }

    public Iterable<String> getAllUsernamesFromStream() {
        return getAllUsers()
                .stream()
                .map(user -> user.getUserName())
                .collect(Collectors.toList());
    }

}
