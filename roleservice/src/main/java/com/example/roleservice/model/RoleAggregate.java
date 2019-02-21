package com.example.roleservice.model;

import com.example.roleservice.command.AssigneeRoleCommand;
import com.example.roleservice.command.DeleteRoleCommand;
import com.example.roleservice.command.UpdateRoleCommand;
import com.example.roleservice.event.AssigneeRoleEvent;
import com.example.roleservice.event.DeletedRoleEvent;
import com.example.roleservice.event.UpdatedRoleEvent;
import lombok.Getter;
import lombok.Setter;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

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

    @CommandHandler
    public RoleAggregate(UpdateRoleCommand updateRoleCommand) {
        this.id = UUID.randomUUID().toString();
        this.roleId = updateRoleCommand.roleId;
        this.roleName = updateRoleCommand.roleName;
        AggregateLifecycle.apply(new UpdatedRoleEvent(updateRoleCommand.id, updateRoleCommand.roleId, updateRoleCommand.roleName));
    }

    @CommandHandler
    public void on(DeleteRoleCommand deleteRoleCommand) {
        AggregateLifecycle.apply(new DeletedRoleEvent(deleteRoleCommand.id, deleteRoleCommand.roleId));
    }

    @EventSourcingHandler
    protected void on(DeletedRoleEvent deletedRoleEvent) {
        this.id = deletedRoleEvent.id;
        this.roleId = deletedRoleEvent.roleId;
    }

    @CommandHandler
    public void on(AssigneeRoleCommand assigneeRoleCommand) {
        AggregateLifecycle.apply(new AssigneeRoleEvent(assigneeRoleCommand.id, assigneeRoleCommand.roleId, assigneeRoleCommand.roleName, assigneeRoleCommand.userId));
    }

    @EventSourcingHandler
    protected void on(AssigneeRoleEvent assigneeRoleEvent) {
        this.id = assigneeRoleEvent.id;
        this.roleId = assigneeRoleEvent.roleId;
        this.roleName = assigneeRoleEvent.roleName;
        this.userId = assigneeRoleEvent.userId;
    }


}
