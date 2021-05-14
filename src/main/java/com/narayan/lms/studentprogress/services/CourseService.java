package com.narayan.lms.studentprogress.services;

import javassist.tools.web.BadHttpRequest;

public interface CourseService {
    Integer getTotalQuestions(Long courseId);
}
