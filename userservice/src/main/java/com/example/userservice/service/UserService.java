package com.example.userservice.service;

import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserService {

    private UserRepository userRepository;

    @PostConstruct
    public void init() {
        User user = userRepository.save(new User("username1", "firstName", "LastName"));
        System.out.println("user.getId() = " + user.getId());

    }

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User get(String id) {
        return userRepository.getOne(id);
    }
}
