package com.example.yourssuinviterbackend.domain.participant.controller.request

import com.example.yourssuinviterbackend.common.enums.InvitationType
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime

@Schema(name = "참가자 등록 Request Body 입니다.")
class CreateParticipantRequest(
    @Schema(description = "참가자의 이름입니다.")
    val name: String,
    @Schema(description = "참가자의 연락처입니다.")
    val phoneNumber: String,
    @Schema(description = "참여자의 추가 입력 정보입니다. JSON 형식으로 보내주세요.")
    val formData: String?,
)