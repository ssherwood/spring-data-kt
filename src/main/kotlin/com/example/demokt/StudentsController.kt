package com.example.demokt

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class StudentsController(private val repository: StudentRepository) {

    /*
    @GetMapping("/students")
    fun students(): List<StudentWithCoursesDTO> {
        return repository.findAll().map { it.toDtoWithCourses() }
    }
    */

    @GetMapping("/students")
    fun students(page: Pageable): Page<Student> = repository.findAll(page)

    @GetMapping("/students/{id}")
    fun student(@PathVariable("id") id: Long): Student = repository.findById(id)

    /**
     * uses entity graph to ensure join
     */
    @GetMapping("/students-courses")
    fun studentsCourse(page: Pageable): Page<Student> {
        return repository.findWithCourses(page)
    }

    @GetMapping("/students-courses/{id}")
    fun studentsCourse(@PathVariable("id") id: Long): Student {
        return repository.findByIdWithCourses(id)
    }
}