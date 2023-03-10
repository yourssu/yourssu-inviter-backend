package com.example.yourssuinviterbackend.application.errorhandling.exception.base

import kr.smartdoctor.api.autoreceipt.dto.ExceptionReasonDto
import org.springframework.http.HttpStatus

// Exception enum class
enum class ExceptionReason(val status: HttpStatus, val reason: String) {
    INVITATION_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 초대장입니다."),
    PARTICIPANT_NOT_FOUND(HttpStatus.NOT_FOUND, "참여자가 존재하지 않습니다."),
    IMAGE_NOT_ACCEPTABLE(HttpStatus.NOT_ACCEPTABLE, "이미지 업로드에 실패했습니다."),
    PARTICIPANT_INFO_INVALID(HttpStatus.BAD_REQUEST, "참여자 정보가 올바르지 않습니다.")
    ;

    fun toDto() = ExceptionReasonDto(
        name = name,
        status = status.name,
        statusCode = status.value(),
        reason = reason,
    )
}
