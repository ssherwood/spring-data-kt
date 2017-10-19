package com.example.demokt

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*

@Entity
data class Course(
        @Id
        @GeneratedValue
        val id: Long = -1,
        val name: String? = null,
        @JsonIgnore
        @ManyToMany(fetch = FetchType.LAZY, mappedBy = "courses")
        val students: Set<Student>? = null
) {
    override fun hashCode(): Int = Objects.hash(id, name)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Course

        if (id != other.id) return false
        if (name != other.name) return false

        return true
    }

    fun toDto(): CourseDTO = CourseDTO(id = id, name = name)
}

data class CourseDTO(val id: Long?, val name: String?)