package com.example.yourssuinviterbackend.application.errorhandling.exception

import com.example.yourssuinviterbackend.application.errorhandling.exception.base.ExceptionReason
import com.example.yourssuinviterbackend.application.errorhandling.exception.base.ResponseStatusReasonException

class ImageNotAcceptableException : ResponseStatusReasonException(ExceptionReason.IMAGE_NOT_ACCEPTABLE)
