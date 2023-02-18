package com.example.yourssuinviterbackend

import javax.persistence.AttributeConverter

class UserRoleConverter : AttributeConverter<UserRole, String> {
    override fun convertToDatabaseColumn(attribute: UserRole): String =
        attribute.role

    override fun convertToEntityAttribute(dbData: String): UserRole =
        UserRole.values().first { it.role == dbData }
}
