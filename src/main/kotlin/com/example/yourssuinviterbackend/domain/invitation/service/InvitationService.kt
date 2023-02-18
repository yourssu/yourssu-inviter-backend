package com.example.yourssuinviterbackend.domain.invitation.service

import com.example.yourssuinviterbackend.common.enums.InvitationType
import com.example.yourssuinviterbackend.common.util.JsonConverterUtil
import com.example.yourssuinviterbackend.domain.invitation.dto.InvitationDto
import com.example.yourssuinviterbackend.domain.invitation.entity.Invitation
import com.example.yourssuinviterbackend.domain.invitation.repository.InvitationRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import javax.swing.ImageIcon

@Service
class InvitationService(
    private val invitationRepository: InvitationRepository,
) {
    fun createInvitation(
        title: String,
        password: String,
        type: InvitationType,
        image: String?,
        description: String,
        startDateTime: LocalDateTime,
        endDateTime: LocalDateTime,
        location: String,
        extra: String?,
        formData: String?,
    ): Long {
        val extraMap = JsonConverterUtil.jsonToMap(extra)
        val formDataMap = JsonConverterUtil.jsonToMap(formData)

        val invitation = Invitation(
            id = 0,
            password = password,
            title = title,
            type = type,
            image = image,
            description = description,
            startDateTime = startDateTime,
            endDateTime = endDateTime,
            location = location,
            extra = extraMap,
            formData = formDataMap,
        )

        return invitationRepository.save(invitation).id
    }

    private fun Invitation.toDto()  = with(this) {
        InvitationDto(
            id = id,
            title = title,
            password = password,
            type = type,
            description = description,
            startDateTime = startDateTime,
            endDateTime = endDateTime,
            location = location,
            extra = extra,
            formData = formData,
            image = image,
        )
    }
}