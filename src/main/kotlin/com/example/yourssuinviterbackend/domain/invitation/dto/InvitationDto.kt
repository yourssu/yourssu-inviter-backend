package com.example.yourssuinviterbackend.domain.invitation.dto

import com.example.yourssuinviterbackend.common.enums.InvitationType
import java.time.LocalDateTime

class InvitationDto(
    val id: Long,

    val title: String,

    val password: String,

    val type: InvitationType,

    val description: String,

    val startDateTime: LocalDateTime,

    val endDateTime: LocalDateTime,

    val location: String,

    val extra: Map<String, String>?,

    val formData: Map<String, String>?,

    val image: String?,
)