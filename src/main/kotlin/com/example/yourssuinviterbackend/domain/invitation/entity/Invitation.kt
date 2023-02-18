package com.example.yourssuinviterbackend.domain.invitation.entity

import com.example.yourssuinviterbackend.BaseTimeEntity
import com.example.yourssuinviterbackend.common.converter.InvitationTypeConverter
import com.example.yourssuinviterbackend.common.enums.InvitationType
import org.hibernate.annotations.Type
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "invitations")
class Invitation (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invitation_id", nullable = false)
    val id: Long,

    @Column(name = "password", nullable = false)
    val password: String,

    @Column(name = "title", nullable = false)
    val title: String,

    @Column(name = "type", nullable = false)
    @Convert(converter = InvitationTypeConverter::class)
    val type: InvitationType,

    @Column(name = "image")
    val image: String?,

    @Column(name = "description", nullable = false)
    val description: String,

    @Column(name = "start_datetime", nullable = false)
    val startDateTime: LocalDateTime,

    @Column(name = "end_datetime", nullable = false)
    val endDateTime: LocalDateTime,

    @Column(name = "location", nullable = false)
    val location: String,

    @Type(type = "json")
    @Column(name = "extra", columnDefinition = "json")
    val extra: Map<String, String>?,

    @Type(type = "json")
    @Column(name = "form_data", columnDefinition = "json")
    val formData: Map<String, String>?
) : BaseTimeEntity()

