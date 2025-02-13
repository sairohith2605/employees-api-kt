package com.srrdev.employeeapi.core

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.Instant
import java.util.*

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntityAbstractModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null
        protected set

    @Column(name = "created_by", updatable = false, nullable = false)
    var createdBy: String? = "SYSTEM"
        protected set

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    var createdAt: Instant? = Instant.now()
        protected set

    @Column(name = "last_modified_by", nullable = false)
    var lastModifiedBy: String? = "SYSTEM"
        protected set

    @LastModifiedDate
    @Column(name = "last_modified_at", nullable = false)
    var lastModifiedAt: Instant? = Instant.now()
        protected set

    @Column(name = "is_active")
    var isActive: Boolean? = true
        protected set
}
