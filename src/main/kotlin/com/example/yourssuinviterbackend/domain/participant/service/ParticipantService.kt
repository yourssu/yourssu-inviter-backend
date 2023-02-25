package com.example.yourssuinviterbackend.domain.participant.service

import com.example.yourssuinviterbackend.application.errorhandling.exception.ParticipantInfoInvalidException
import com.example.yourssuinviterbackend.common.util.JsonConverterUtil
import com.example.yourssuinviterbackend.domain.invitation.repository.InvitationRepository
import com.example.yourssuinviterbackend.domain.participant.entity.Participant
import com.example.yourssuinviterbackend.domain.participant.repository.ParticipantRepository
import org.apache.commons.codec.language.Nysiis
import org.springframework.scheduling.support.SimpleTriggerContext
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
}