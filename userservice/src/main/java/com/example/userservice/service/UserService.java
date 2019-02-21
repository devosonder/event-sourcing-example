package com.example.userservice.service;

import com.example.userservice.event.UpdatedRoleEvent;
import com.example.userservice.model.UserServiceUser;
import com.example.userservice.repository.UserRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserService {

    private UserRepository userRepository;

    @PostConstruct
    public void init() {
        UserServiceUser user = userRepository.save(new UserServiceUser("username1", "firstName", "LastName"));
        System.out.println("user.getId() = " + user.getId());

    }

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserServiceUser create(UserServiceUser user) {
        return userRepository.save(user);
    }

    public UserServiceUser get(String id) {
        return userRepository.getOne(id);
    }

    @EventHandler
    public void on(UpdatedRoleEvent event) {
        System.out.println("event.roleName = " + event.roleName);
    }

}
