package com.example.yourssuinviterbackend.domain.invitation.repository

import com.example.yourssuinviterbackend.domain.invitation.entity.Invitation
import org.springframework.data.jpa.repository.JpaRepository

interface InvitationRepository: JpaRepository<Invitation, Long> {
}