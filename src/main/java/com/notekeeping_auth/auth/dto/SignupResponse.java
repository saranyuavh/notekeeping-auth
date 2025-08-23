package com.notekeeping_auth.auth.dto;

import java.util.UUID;

public record SignupResponse(long id, String email, String username, String firstName, String lastName) {}