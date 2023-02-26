package com.example.yourssuinviterbackend.domain.participant.service

import com.example.yourssuinviterbackend.application.errorhandling.exception.InvitationNotFoundException
import com.example.yourssuinviterbackend.application.errorhandling.exception.ParticipantInfoInvalidException
import com.example.yourssuinviterbackend.application.errorhandling.exception.ParticipantNotFoundException
import com.example.yourssuinviterbackend.common.util.JsonConverterUtil
import com.example.yourssuinviterbackend.domain.invitation.repository.InvitationRepository
import com.example.yourssuinviterbackend.domain.participant.controller.response.GetParticipantResponse
import com.example.yourssuinviterbackend.domain.participant.entity.Participant
import com.example.yourssuinviterbackend.domain.participant.repository.ParticipantRepository
import org.springframework.stereotype.Service

@Service
class ParticipantService(
    private val participantRepository: ParticipantRepository,
    private val invitationRepository: InvitationRepository,
) {
    fun createParticipant(
        invitationId: Long,
        name: String,
        phoneNumber: String,
        formData: String?
    ): Long {
        val invitation = invitationRepository.findById(invitationId).get()

        val formDataMap = JsonConverterUtil.jsonToMap(formData)

        if(invitation.formData != null)
            if(formDataMap == null ||
                (formDataMap.keys != invitation.formData.keys)
            ) throw ParticipantInfoInvalidException()

        val participant = Participant(
            name = name,
            phoneNumber = phoneNumber,
            formData = formDataMap,
            invitation = invitation,
        )

        return participantRepository.save(participant).id
    }

    private fun Participant.toGetParticipantResponse() = with(this) {
                GetParticipantResponse(
                    name = name,
                    phoneNumber = phoneNumber,
                    formData = formData
                )
    }
    fun getParticipant(invitationId: Long): List<GetParticipantResponse> =
        invitationRepository.getInvitationById(invitationId)?.let { invitation ->
            participantRepository
            .getAllByInvitation(invitation)
            ?.map { it.toGetParticipantResponse() }
                ?: throw ParticipantNotFoundException()
        } ?: throw InvitationNotFoundException()
}