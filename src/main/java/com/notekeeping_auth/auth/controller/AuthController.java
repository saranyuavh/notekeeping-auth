package com.notekeeping_auth.auth.controller;

import com.notekeeping_auth.auth.Exception.AuthException;
import com.notekeeping_auth.auth.dto.SignupRequest;
import com.notekeeping_auth.auth.dto.SignupResponse;
import com.notekeeping_auth.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    AuthService authService;
    @Autowired
    void setAuthService(AuthService authService) {
        this.authService = authService;
    }
    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody SignupRequest signupRequest) {

        try {
            SignupResponse response = authService.signup(signupRequest);

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (AuthException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
        }
    }

    @GetMapping("/")
    public String basic() {
        return "Finally!";
    }
}
