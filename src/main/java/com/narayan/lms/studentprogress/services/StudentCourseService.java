package com.narayan.lms.studentprogress.services;

public interface StudentCourseService {
    Integer completedNumberOfQuestions(Long courseId, Long StudentId);
}
