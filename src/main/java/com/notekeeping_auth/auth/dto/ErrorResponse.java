package com.notekeeping_auth.auth.dto;

import org.springframework.stereotype.Component;

public record ErrorResponse(String errorCode, String message) {
}
