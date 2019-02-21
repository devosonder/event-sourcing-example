package com.example.roleservice.command;

import com.example.roleservice.common.BaseCommand;

public class UpdateRoleCommand extends BaseCommand<String> {
    public final String roleId;
    public final String roleName;

    public UpdateRoleCommand(String id, String roleId, String roleName) {
        super(id);
        this.roleId = roleId;
        this.roleName = roleName;
    }
}
