package com.example.yourssuinviterbackend.domain.invitation.service

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.ObjectMetadata
import com.example.yourssuinviterbackend.common.enums.InvitationType
import com.example.yourssuinviterbackend.common.util.JsonConverterUtil
import com.example.yourssuinviterbackend.domain.invitation.dto.InvitationDto
import com.example.yourssuinviterbackend.domain.invitation.entity.Invitation
import com.example.yourssuinviterbackend.domain.invitation.repository.InvitationRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.time.LocalDateTime

@Service
class InvitationService(
    private val amazonS3: AmazonS3,
    private val invitationRepository: InvitationRepository,
) {
    @Value("\${aws.bucketName}")
    lateinit var bucketName: String

    fun uploadImage(multipartFile: MultipartFile): String {
        val keyName = "image/" + multipartFile.originalFilename
        val metadata = ObjectMetadata()
        metadata.contentType = multipartFile.contentType
        metadata.contentLength = multipartFile.size
        amazonS3.putObject(bucketName, keyName, multipartFile.inputStream, metadata)

        return amazonS3.getUrl(bucketName, keyName).toString()
    }

    fun createInvitation(
        title: String,
        password: String,
        type: InvitationType,
        imageUrl: String?,
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
            password = password,
            title = title,
            type = type,
            imageUrl = imageUrl,
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
            image = imageUrl,
        )
    }
}