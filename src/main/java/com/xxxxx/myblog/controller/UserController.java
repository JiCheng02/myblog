package com.xxxxx.myblog.controller;

import com.xxxxx.myblog.entity.User;
import com.xxxxx.myblog.repository.UserRepository;
import jdk.nashorn.internal.runtime.arrays.IteratorAction;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.xml.ws.http.HTTPException;
import java.util.Iterator;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/{login}")
    public User findOne(@PathVariable String login) throws HTTPException {
        User result = userRepository.findByLogin(login);
        if(result == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"This user does not found");
        }
        return result;
    }
}
