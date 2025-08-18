package com.notekeeping_auth.auth.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@ToString(exclude = "password")
@EqualsAndHashCode
@Component
public class SignupRequest {
    String email;

    String password;

    String firstName;

    String lastName;

    String username;
}
