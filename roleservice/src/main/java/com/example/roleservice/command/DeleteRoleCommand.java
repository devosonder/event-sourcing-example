package com.example.roleservice.command;

import com.example.roleservice.common.BaseCommand;

public class DeleteRoleCommand extends BaseCommand<String> {
    public final String roleId;

    public DeleteRoleCommand(String id, String roleId) {
        super(id);
        this.roleId = roleId;
    }
}
