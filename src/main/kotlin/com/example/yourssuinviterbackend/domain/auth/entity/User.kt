package com.example.yourssuinviterbackend.domain.auth.entity

import com.example.yourssuinviterbackend.BaseTimeEntity
import com.example.yourssuinviterbackend.UserRole
import com.example.yourssuinviterbackend.UserRoleConverter
import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    val id: Long,

    @Column(name = "email", nullable = false)
    val email: String,

    @Column(name = "password", nullable = false)
    val password: String,

    @Column(name = "username", nullable = false)
    val username: String,

    @Size(max = 255)
    @NotNull
    @Column(name = "refresh_token")
    var refreshToken: String?,

    @Size(max = 255)
    @NotNull
    @Column(name = "user_role", nullable = false)
    @Convert(converter = UserRoleConverter::class)
    val userRole: UserRole,
) : BaseTimeEntity()
