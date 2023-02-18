package com.example.yourssuinviterbackend.domain.auth.repository

import com.example.yourssuinviterbackend.domain.auth.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long>