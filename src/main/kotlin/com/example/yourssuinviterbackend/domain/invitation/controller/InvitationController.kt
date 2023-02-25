package com.example.yourssuinviterbackend.domain.invitation.controller

import com.example.yourssuinviterbackend.domain.invitation.controller.request.CreateInvitationRequest
import com.example.yourssuinviterbackend.domain.invitation.controller.response.CreateInvitationResponse
import com.example.yourssuinviterbackend.domain.invitation.controller.response.UploadImageResponse
import com.example.yourssuinviterbackend.domain.invitation.service.InvitationService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/invitation")
class InvitationController(
    private val invitationService: InvitationService
) {
    @Operation(
        summary = "초대장 이미지 업로드하기",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "OK",
            ),
            ApiResponse(
                responseCode = "404",
                description = "해당하는 정보가 없습니다.",
                content = arrayOf(Content(schema = Schema(hidden = true))),
            ),
        ],
    )
    @PostMapping(path = ["/image"], consumes = [MULTIPART_FORM_DATA_VALUE])
    fun uploadInvitationImage(
        @RequestPart
        image: MultipartFile,
    ): UploadImageResponse {
        val imageUrl = invitationService.uploadImage(
            multipartFile = image,
        )

        return UploadImageResponse(
            url = imageUrl
        )
    }

    @Operation(
        summary = "초대장 생성하기",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "OK",
            ),
            ApiResponse(
                responseCode = "404",
                description = "해당하는 정보가 없습니다.",
                content = arrayOf(Content(schema = Schema(hidden = true))),
            ),
        ],
    )
    @PostMapping
    fun createInvitation(
        @RequestBody
        createInvitationRequest: CreateInvitationRequest,
    ): CreateInvitationResponse {
        val invitationId = invitationService.createInvitation(
            title = createInvitationRequest.title,
            password = createInvitationRequest.password,
            type = createInvitationRequest.type,
            imageUrl = createInvitationRequest.imageUrl,
            description = createInvitationRequest.description,
            startDateTime = createInvitationRequest.startDateTime,
            endDateTime = createInvitationRequest.endDateTime,
            location = createInvitationRequest.location,
            extra = createInvitationRequest.extra,
            formData = createInvitationRequest.formData,
        )

        return CreateInvitationResponse(
            invitationId = invitationId
        )
    }
}