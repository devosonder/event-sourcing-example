package com.example.userservice.event;

import com.example.userservice.common.BaseEvent;

public class UpdatedRoleEvent extends BaseEvent<String> {
    public final String roleId;
    public final String roleName;

    public UpdatedRoleEvent(String id, String roleId, String roleName) {
        super(id);
        this.roleId = roleId;
        this.roleName = roleName;
    }
}
