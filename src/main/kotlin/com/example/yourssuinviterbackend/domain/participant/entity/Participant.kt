package com.example.yourssuinviterbackend.domain.participant.entity

import com.example.yourssuinviterbackend.BaseTimeEntity
import com.example.yourssuinviterbackend.domain.invitation.entity.Invitation
import org.hibernate.annotations.Type
import javax.persistence.*

@Entity
@Table(name = "participants")
class Participant (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participant_id", nullable = false)
    val id: Long,

    @ManyToOne
    @JoinColumn(name = "invitation_id")
    val invitation: Invitation,

    @Column(name = "name", nullable = false)
    val name: String,

    @Column(name = "contact", nullable = false)
    val contact: String,

     @Type(type = "json")
    @Column(name = "extra", columnDefinition = "json")
    val extra: List<Map<String, Any>>,
) : BaseTimeEntity()