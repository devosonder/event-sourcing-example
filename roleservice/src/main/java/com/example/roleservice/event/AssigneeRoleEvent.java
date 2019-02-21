package com.example.roleservice.event;

import com.example.roleservice.common.BaseEvent;

public class AssigneeRoleEvent extends BaseEvent<String> {
    public final String roleId;
    public final String roleName;
    public final String userId;

    public AssigneeRoleEvent(String id, String roleId, String roleName, String userId) {
        super(id);
        this.roleId = roleId;
        this.roleName = roleName;
        this.userId = userId;
    }
}
