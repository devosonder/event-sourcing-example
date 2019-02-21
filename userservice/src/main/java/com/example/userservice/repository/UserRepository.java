package com.example.userservice.repository;

import com.example.userservice.model.UserServiceUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserServiceUser, String> {
}
