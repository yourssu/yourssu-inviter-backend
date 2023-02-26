package com.example.yourssuinviterbackend.domain.participant.controller.response

data class GetParticipantResponse(
    val name: String,
    val phoneNumber: String,
    val formData: Map<String, String>?,
)
