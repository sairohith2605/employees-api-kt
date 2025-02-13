package com.srrdev.employeeapi.employee

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("employees")
class EmployeeController(val service: EmployeeService) {

    @GetMapping
    fun getEmployees(): ResponseEntity<List<Employee>> {
        return ResponseEntity.ok(service.getAllData())
    }

    @GetMapping("{id}")
    fun getSpecificEmployee(@PathVariable("id") id: UUID): ResponseEntity<Employee> {
        return ResponseEntity.ok(service.getDataById(id).orElse(null))
    }

    @PostMapping
    fun createNewEmployee(@RequestBody employee: Employee): ResponseEntity<Employee> {
        return ResponseEntity.ok(service.createData(employee))
    }

    @PutMapping("{id}")
    fun updateEmployee(@PathVariable("id") id: UUID, @RequestBody employee: Employee): ResponseEntity<Employee> {
        return ResponseEntity.ok(service.updateData(id, employee))
    }

    @DeleteMapping("{id}")
    fun deleteSpecificEmployee(@PathVariable("id") id: UUID): ResponseEntity<Any> {
        service.deleteData(id);
        return ResponseEntity.noContent().build()
    }
}
