package com.example.yourssuinviterbackend.application.errorhandling.exception

import com.example.yourssuinviterbackend.application.errorhandling.exception.base.ExceptionReason
import com.example.yourssuinviterbackend.application.errorhandling.exception.base.ResponseStatusReasonException

class ParticipantInfoInvalidException : ResponseStatusReasonException(ExceptionReason.PARTICIPANT_INFO_INVALID)
