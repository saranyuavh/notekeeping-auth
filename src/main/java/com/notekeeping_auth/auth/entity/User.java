package com.notekeeping_auth.auth.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users") // avoid reserved keyword 'user'
@Data                   // generates getters, setters, equals, hashCode, toString
@NoArgsConstructor
@AllArgsConstructor
@Builder                 // allows User.builder().username(...).build()
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // CockroachDB identity
    @Column(name = "id")
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username", nullable = false, unique = true)
    private String username;
}

