package com.example.yourssuinviterbackend.domain.auth.controller

import com.example.yourssuinviterbackend.domain.auth.service.AuthService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authService: AuthService,
) {
    @Operation(
        summary = "테스트 메소드",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "OK",
            ),
        ],
    )
    @GetMapping
    fun test(): String {
        return "Hello World!"
    }

    @Operation(
        summary = "DB 테스트 메소드",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "OK",
            ),
        ],
    )
    @PostMapping
    fun dbTest(): String {
        return authService.createUserId()
    }
}