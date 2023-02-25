package com.example.yourssuinviterbackend.domain.participant.entity

import com.example.yourssuinviterbackend.BaseTimeEntity
import com.example.yourssuinviterbackend.domain.invitation.entity.Invitation
import org.hibernate.annotations.Type
import javax.persistence.*

@Entity
@Table(name = "participants")
class Participant (
    @ManyToOne
    @JoinColumn(name = "invitation_id")
    val invitation: Invitation,

    @Column(name = "name", nullable = false)
    val name: String,

    @Column(name = "phone_number", nullable = false)
    val phoneNumber: String,

     @Type(type = "json")
    @Column(name = "extra", columnDefinition = "json")
    val formData: Map<String, String>?,
) : BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_id", nullable = false)
    val id: Long = 0
}
