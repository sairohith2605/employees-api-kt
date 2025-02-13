package com.srrdev.employeeapi.employee

import com.srrdev.employeeapi.core.BaseEntityAbstractModel
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "employees")
class Employee : BaseEntityAbstractModel() {

    @Column(name = "first_name", length = 128, nullable = false)
    val firstName: String? = null

    @Column(name = "middle_name", length = 128)
    val middleName: String? = null

    @Column(name = "last_name", length = 128, nullable = false)
    val lastName: String? = null

    @Column(name = "date_of_birth", nullable = false)
    val dateOfBirth: LocalDate? = null

    @Column(name = "mobile", length = 14, nullable = false)
    val mobile: String? = null

    @Column(name = "alternate_mobile", length = 14)
    val alternateMobile: String? = null

    @Column(name = "date_of_joining", nullable = false)
    val dateOfJoining: LocalDate? = null
}
