package com.example.yourssuinviterbackend.domain.participant.repository

import com.example.yourssuinviterbackend.domain.participant.entity.Participant
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ParticipantRepository: JpaRepository<Participant, Long>