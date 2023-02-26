package com.example.yourssuinviterbackend.application.errorhandling.exception

import com.example.yourssuinviterbackend.application.errorhandling.exception.base.ExceptionReason
import com.example.yourssuinviterbackend.application.errorhandling.exception.base.ResponseStatusReasonException

class ParticipantNotFoundException : ResponseStatusReasonException(ExceptionReason.PARTICIPANT_NOT_FOUND)