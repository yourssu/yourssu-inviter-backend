package com.example.yourssuinviterbackend.domain.invitation.controller.response

import com.example.yourssuinviterbackend.common.enums.InvitationType
import java.time.LocalDateTime
data class ReadInvitationResponse(
    val title: String,
    val type: InvitationType,
    val image: String?,
    val description: String,
    val startDateTime: LocalDateTime,
    val endDateTime: LocalDateTime,
    val location: String,
    val extra: Map<String, String>?,
    val formData: Map<String, String>?
)