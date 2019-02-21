package com.example.roleservice.event;

import com.example.roleservice.common.BaseEvent;

public class DeletedRoleEvent extends BaseEvent<String> {
    public final String roleId;

    public DeletedRoleEvent(String id, String roleId) {
        super(id);
        this.roleId = roleId;
    }
}
