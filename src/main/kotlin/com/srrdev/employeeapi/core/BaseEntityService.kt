package com.srrdev.employeeapi.core

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
abstract class BaseEntityService<T : Any, ID : Any, R : JpaRepository<T, ID>>(val repository: R) {

    fun getAllData(): List<T> {
        return repository.findAll()
    }

    fun getDataById(id: ID): Optional<T> {
        return repository.findById(id)
    }

    fun createData(data: T): T {
        return repository.save(data)
    }

    fun updateData(id: ID, data: T): T? {
        if (!repository.existsById(id)) {
            return null
        }
        return repository.save(data)
    }

    fun deleteData(id: ID) {
        repository.deleteById(id)
    }
}
