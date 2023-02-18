package com.example.yourssuinviterbackend.common.converter

import com.example.yourssuinviterbackend.common.enums.InvitationType
import javax.persistence.AttributeConverter

class InvitationTypeConverter : AttributeConverter<InvitationType, String> {
    override fun convertToDatabaseColumn(attribute: InvitationType): String = attribute.type

    override fun convertToEntityAttribute(dbData: String): InvitationType = InvitationType.valueOf(dbData)
}
