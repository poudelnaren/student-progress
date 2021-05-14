package com.narayan.lms.studentprogress.repository;

import com.narayan.lms.studentprogress.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
