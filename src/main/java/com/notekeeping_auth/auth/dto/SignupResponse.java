package com.notekeeping_auth.auth.dto;

import com.notekeeping_auth.auth.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

public record SignupResponse(UUID id, String email, String username, String firstName, String lastName) {
}