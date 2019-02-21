package com.example.roleservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Role implements Serializable {
    public Role(String roleName) {
        this.roleName = roleName;
    }

    @Id
    @GenericGenerator(name = "UserIdGenerator", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UserIdGenerator")
    @Column(name = "id", length = 36, nullable = false, unique = true, updatable = false)
    private String id;

    @Column(name = "role_name", length = 60, unique = true, nullable = false)
    private String roleName;

}
