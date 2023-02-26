package com.example.yourssuinviterbackend.domain.participant.controller

import com.example.yourssuinviterbackend.domain.participant.controller.request.CreateParticipantRequest
import com.example.yourssuinviterbackend.domain.participant.controller.response.CreateParticipantResponse
import com.example.yourssuinviterbackend.domain.participant.service.ParticipantService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/participant")
class ParticipantController(
    private val participantService: ParticipantService,
) {
    @Operation(
        summary = "참가자 등록하기",
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
    @PostMapping("/{invitationId}")
    fun createParticipant(
        @PathVariable
        invitationId: Long,
        @RequestBody
        createParticipantRequest: CreateParticipantRequest,
    ): CreateParticipantResponse {
        val participantId = participantService.createParticipant(
            invitationId = invitationId,
            name = createParticipantRequest.name,
            phoneNumber = createParticipantRequest.phoneNumber,
            formData = createParticipantRequest.formData,
        )

        return CreateParticipantResponse(
            participantId = participantId
        )
    }

    @Operation(
        summary = "참가자 조회하기",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "OK"
            ),
            ApiResponse(
                responseCode = "404",
                description = "해당하는 정보가 없습니다.",
                content = arrayOf(Content(schema = Schema(hidden = true))),
            ),
        ],
    )
    @GetMapping("/{invitationId}")
    fun getParticipant(@PathVariable invitationId: Long) = participantService.getParticipant(invitationId)
}