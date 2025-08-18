package com.notekeeping_auth.auth.repository;

import com.notekeeping_auth.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
}
