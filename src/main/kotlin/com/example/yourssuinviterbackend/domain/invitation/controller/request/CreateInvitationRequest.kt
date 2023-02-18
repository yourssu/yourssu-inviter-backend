package com.example.yourssuinviterbackend.domain.invitation.controller.request

import java.time.LocalDateTime

class CreateInvitationRequest(
    val title: String,

    val password: String,

    val type: String,

    val description: String,

    val startDateTime: LocalDateTime,

    val endDateTime: LocalDateTime,

    val location: String,

    val extra: String,

    val formData: String,

    val image: ByteArray,
)