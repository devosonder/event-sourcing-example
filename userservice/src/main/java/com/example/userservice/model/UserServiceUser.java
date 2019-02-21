package com.example.userservice.model;

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
public class UserServiceUser implements Serializable {

    public UserServiceUser(String username, String firstName, String lastName) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Id
    @GenericGenerator(name = "UserIdGenerator", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UserIdGenerator")
    @Column(name = "id", length = 36, nullable = false, unique = true, updatable = false)
    private String id;

    @Column(name = "username", length = 60, unique = true, nullable = false)
    private String username;

    @Column(name = "firstName", length = 100, nullable = false)
    private String firstName;

    @Column(name = "lastName", length = 100, nullable = false)
    private String lastName;




}
