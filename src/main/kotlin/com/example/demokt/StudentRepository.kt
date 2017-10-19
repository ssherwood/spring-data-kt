package com.example.demokt

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : JpaRepository<Student, Long> {
    fun findById(id: Long): Student

    @Query("from Student", countQuery = "select count(s.id) from Student s")
    @EntityGraph(value = "Student.withCourses", type = EntityGraphType.LOAD)
    fun findWithCourses(page: Pageable): Page<Student>

    @Query("from Student where id = ?1")
    @EntityGraph(value = "Student.withCourses", type = EntityGraphType.LOAD)
    fun findByIdWithCourses(id: Long): Student
}