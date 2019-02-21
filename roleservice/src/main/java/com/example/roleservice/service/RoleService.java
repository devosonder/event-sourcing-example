package com.example.roleservice.service;

import com.example.roleservice.command.UpdateRoleCommand;
import com.example.roleservice.event.UpdatedRoleEvent;
import com.example.roleservice.model.Role;
import com.example.roleservice.repository.RoleRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.AllowReplay;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class RoleService {

    private CommandGateway commandGateway;

    private RoleRepository roleRepository;
    @PostConstruct
    public void init() {
        Role role = roleRepository.save(new Role("Role " + UUID.randomUUID().toString() ));
        System.out.println("role.getId() = " + role.getId());

    }


    @Autowired
    public RoleService(RoleRepository roleRepository, CommandGateway commandGateway) {
        this.roleRepository = roleRepository;
        this.commandGateway = commandGateway;
    }

    public CompletableFuture<Object> create(Role role) {
        if (role.getId() != null) {
            return commandGateway.send(new UpdateRoleCommand(role.getId(), role.getId(), role.getRoleName()));

        }

        role = roleRepository.save(role);
        return commandGateway.send(new UpdateRoleCommand(role.getId(), role.getId(), role.getRoleName()));
    }

    @EventHandler
    @AllowReplay(false)
    public void on(UpdatedRoleEvent event) {
        System.out.println("event.roleName = " + event.roleName);
    }

    public Role get(String id) {
        return roleRepository.getOne(id);
    }
}
