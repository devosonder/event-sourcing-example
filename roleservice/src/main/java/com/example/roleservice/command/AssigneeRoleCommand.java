package com.example.roleservice.command;

import com.example.roleservice.common.BaseCommand;

public class AssigneeRoleCommand extends BaseCommand<String> {
    public final String roleId;
    public final String roleName;
    public final String userId;

    public AssigneeRoleCommand(String id, String roleId, String roleName, String userId) {
        super(id);
        this.roleId = roleId;
        this.roleName = roleName;
        this.userId = userId;
    }
}
