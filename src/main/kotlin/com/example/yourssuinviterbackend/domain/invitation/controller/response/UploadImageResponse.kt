package com.example.yourssuinviterbackend.domain.invitation.controller.response

import com.example.yourssuinviterbackend.common.enums.InvitationType
import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.scheduling.annotation.Scheduled
import java.time.LocalDateTime

@Schema(name = "초대장 생성 Response Body 입니다.")
class UploadImageResponse(
    @Schema(description = "초대장 이미지 url의 주소입니다.")
    val url: String,
)