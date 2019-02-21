package com.example.userservice.model;

import com.example.userservice.event.AssigneeRoleEvent;
import com.example.userservice.event.DeletedRoleEvent;
import com.example.userservice.event.UpdatedRoleEvent;
import lombok.Getter;
import lombok.Setter;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Getter
@Setter
public class RoleAggregate {
    @AggregateIdentifier
    private String id;

    private String roleId;

    private String roleName;
    private String userId;

    public RoleAggregate() {
    }

    @EventSourcingHandler
    protected void on(UpdatedRoleEvent updatedRoleEvent) {
        this.id = updatedRoleEvent.id;
        this.roleId = updatedRoleEvent.roleId;
        this.roleName = updatedRoleEvent.roleName;
    }

    @EventSourcingHandler
    protected void on(DeletedRoleEvent deletedRoleEvent) {
        this.id = deletedRoleEvent.id;
        this.roleId = deletedRoleEvent.roleId;
    }

    @EventSourcingHandler
    protected void on(AssigneeRoleEvent assigneeRoleEvent) {
        this.id = assigneeRoleEvent.id;
        this.roleId = assigneeRoleEvent.roleId;
        this.roleName = assigneeRoleEvent.roleName;
        this.userId = assigneeRoleEvent.userId;
    }


}
