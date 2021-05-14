package com.narayan.lms.studentprogress.repository;

import com.narayan.lms.studentprogress.entity.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {

    @Query(value = "SELECT completed_number_of_questions FROM student_course WHERE course_id = ?1 && student_id = ?2", nativeQuery = true)
    Integer completedNumberOfQuestions(Long courseId, Long studentId);
}
