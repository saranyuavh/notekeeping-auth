package com.notekeeping_auth.auth.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
//@ToString(exclude = "password")  // avoid leaking password in logs
public class SignupRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String username;
}
