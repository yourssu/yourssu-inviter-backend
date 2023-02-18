package com.example.yourssuinviterbackend.domain.invitation.controller

import com.example.yourssuinviterbackend.domain.invitation.controller.request.CreateInvitationRequest
import com.example.yourssuinviterbackend.domain.invitation.controller.response.CreateInvitationResponse
import com.example.yourssuinviterbackend.domain.invitation.service.InvitationService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/invitation")
class InvitationController(
    private val invitationService: InvitationService
) {
//    @Operation(
//        summary = "고객 조회",
//        responses = [
//            ApiResponse(
//                responseCode = "200",
//                description = "OK",
//            ),
//            ApiResponse(
//                responseCode = "404",
//                description = "해당하는 정보가 없습니다.",
//                content = arrayOf(Content(schema = Schema(hidden = true))),
//            ),
//        ],
//    )
//    @PostMapping
//    fun createInvitation(
//        @RequestBody
//        createInvitationRequest: CreateInvitationRequest
//    ): CreateInvitationResponse {
//
//    }
}