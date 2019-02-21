package com.example.userservice.event;

import com.example.userservice.common.BaseEvent;

public class DeletedRoleEvent extends BaseEvent<String> {
    public final String roleId;

    public DeletedRoleEvent(String id, String roleId) {
        super(id);
        this.roleId = roleId;
    }
}
