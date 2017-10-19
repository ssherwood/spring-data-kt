package com.example.demokt

import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
@NamedEntityGraph(name = "Student.withCourses" , attributeNodes = arrayOf(NamedAttributeNode("courses")))
data class Student(
        @Id
        @GeneratedValue
        val id: Long = -1,
        val firstName: String? = null,
        val lastName: String? = null,
        val dateOfBirth: LocalDate? = null,
        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(name = "students_courses",
                joinColumns = arrayOf(JoinColumn(name = "course_id")),
                inverseJoinColumns = arrayOf(JoinColumn(name = "student_id"))
        )
        val courses: Set<Course>? = null
) {
    override fun hashCode(): Int = Objects.hash(id, firstName, lastName, dateOfBirth)

    // DTOs
    fun toDto(): StudentDTO = StudentDTO(id = id, firstName = firstName, lastName = lastName, dateOfBirth = dateOfBirth)
    fun toDtoWithCourses(): StudentWithCoursesDTO =
            StudentWithCoursesDTO(id = id, firstName = firstName, lastName = lastName, dateOfBirth = dateOfBirth, courses = courses?.map { it.toDto() })
}

data class StudentDTO(val id: Long?,
                      val firstName: String?,
                      val lastName: String?,
                      val dateOfBirth: LocalDate?)

data class StudentWithCoursesDTO(val id: Long?,
                                 val firstName: String?,
                                 val lastName: String?,
                                 val dateOfBirth: LocalDate?,
                                 val courses: List<CourseDTO>?)