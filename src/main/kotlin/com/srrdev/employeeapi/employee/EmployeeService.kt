package com.srrdev.employeeapi.employee

import com.srrdev.employeeapi.core.BaseEntityService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class EmployeeService(override val repository: EmployeeRepository) :
    BaseEntityService<Employee, UUID, EmployeeRepository>(repository)
