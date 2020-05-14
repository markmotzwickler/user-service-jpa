package com.example.userservicejpa.controller;

import com.example.userservicejpa.model.User;
import com.example.userservicejpa.repository.UserRepository;
import com.example.userservicejpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public @ResponseBody Iterable<User> getUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("userId") int id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/users/names", method = RequestMethod.GET)
    public @ResponseBody Iterable<String> getAllUsernames() {
        return userService.getAllUsernames();
    }

    @RequestMapping(value = "/users/nameslist", method = RequestMethod.GET)
    public Iterable<String> getAllUsernamesFromStream() {
        return userService.getAllUsernamesFromStream();
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }

}
