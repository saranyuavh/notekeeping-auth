package com.notekeeping_auth.auth.repository;

import com.notekeeping_auth.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    public boolean existsByEmail(String email);

    public boolean existsByUsername(String username);

    public Optional<User> getUserByEmail(String email);

    public Optional<User> getUserByUsername(String username);

}
