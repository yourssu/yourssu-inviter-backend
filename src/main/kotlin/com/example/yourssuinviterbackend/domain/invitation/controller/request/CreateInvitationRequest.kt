package com.example.yourssuinviterbackend.domain.invitation.controller.request

import com.example.yourssuinviterbackend.common.enums.InvitationType
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime

// 초대장 생성 request body
@Schema(name = "초대장 생성 Request Body 입니다.")
class CreateInvitationRequest(
    @Schema(description = "초대장의 제목입니다.")
    val title: String,
    @Schema(description = "초대장의 비밀번호입니다,")
    val password: String,
    @Schema(description = "초대장의 타입입니다.")
    val type: InvitationType,
    @Schema(description = "초대장의 설명입니다.")
    val description: String,
    @Schema(description = "일정의 시작 시간입니다.")
    val startDateTime: LocalDateTime,
    @Schema(description = "일정의 종료 시간입니다.")
    val endDateTime: LocalDateTime,
    @Schema(description = "일정의 장소 링크입니다.")
    val location: String,
    @Schema(description = "초대장의 추가 제공 정보입니다. JSON 형식으로 보내주세요.")
    val extra: String?,
    @Schema(description = "참여자의 추가 입력 정보입니다. JSON 형식으로 보내주세요.")
    val formData: String?,
    @Schema(description = "초대장의 이미지 주소입니다.")
    val imageUrl: String?,
)