package com.example.yourssuinviterbackend.domain.invitation.repository

import com.example.yourssuinviterbackend.domain.invitation.entity.Invitation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InvitationRepository: JpaRepository<Invitation, Long> {
    fun getInvitationById(id: Long): Invitation?
}