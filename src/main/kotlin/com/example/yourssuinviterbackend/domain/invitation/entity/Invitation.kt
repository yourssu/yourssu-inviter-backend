package com.example.yourssuinviterbackend.domain.invitation.entity

import com.example.yourssuinviterbackend.BaseTimeEntity
import com.example.yourssuinviterbackend.ExtraData
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

    @Lob
    @Column(name = "image", columnDefinition = "MEDIUMBLOB")
    val image: ByteArray,

    @Column(name = "description", nullable = false)
    val description: String,

    @Column(name = "date", nullable = false)
    val date: LocalDateTime,

    @Column(name = "location", nullable = false)
    val location: String,

    @Type(type = "json")
    @Column(name = "extra", columnDefinition = "json")
    val extra: List<ExtraData>?,

    @Type(type = "json")
    @Column(name = "form_data", columnDefinition = "json")
    val formData: List<ExtraData>?
) : BaseTimeEntity()

