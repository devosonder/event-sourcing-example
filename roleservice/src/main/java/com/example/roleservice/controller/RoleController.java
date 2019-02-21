package com.example.roleservice.controller;

import com.example.roleservice.model.Role;
import com.example.roleservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/role")
public class RoleController {
    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/")
    public CompletableFuture<Object> create(@RequestBody Role role) {
        return roleService.create(role);
    }

    @GetMapping("/")
    public Role get(String id) {
        return roleService.get(id);
    }
}
