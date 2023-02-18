package com.example.yourssuinviterbackend.domain.auth.service

import com.example.yourssuinviterbackend.UserRole
import com.example.yourssuinviterbackend.domain.auth.entity.User
import com.example.yourssuinviterbackend.domain.auth.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userRepository: UserRepository,
) {
    fun createUserId(): String {
        val user = User(
            id = 0, // auto_increment
            email = "mail",
            password = "password",
            username = "username",
            refreshToken = "refreshToken",
            userRole = UserRole.ADMIN,
        )

        return userRepository.save(user).username
    }
}