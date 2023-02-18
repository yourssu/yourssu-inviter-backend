package com.example.yourssuinviterbackend.common.converter

import com.example.yourssuinviterbackend.common.enums.InvitationType
import javax.persistence.AttributeConverter

class InvitationTypeListConverter : AttributeConverter<List<InvitationType>, String> {
    override fun convertToDatabaseColumn(attribute: List<InvitationType>): String =
        attribute.joinToString(",") { it.type }

    override fun convertToEntityAttribute(dbData: String): List<InvitationType> {
        val invitationTypes = dbData.split(",")

        return invitationTypes.map { InvitationType.valueOf("it") }
    }
}
