package com.narayan.lms.studentprogress.services;

import com.narayan.lms.studentprogress.repository.CourseRepository;
import javassist.tools.web.BadHttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentProgressServiceImpl implements StudentProgressService {

    @Autowired
    private CourseService courseService;

    @Autowired
    private  StudentCourseService studentCourseService;

    private static final Logger logger = LoggerFactory.getLogger(StudentProgressServiceImpl.class);

    @Override
    public double getStudentProgress(Long studentId, Long courseId) {
        logger.info("About to retrieve total questions using courseId: {}", courseId);
        Integer totalQuestions = courseService.getTotalQuestions(courseId);

        logger.info("About to retrieve total completed questions using courseId: {}, studentId: {}", courseId, studentId);
        Integer totalNumberOfCompletedQuestions = studentCourseService.completedNumberOfQuestions(courseId, studentId);

        double leftPercentage = 100 - (totalNumberOfCompletedQuestions*100)/totalQuestions;

        return leftPercentage;
    }
}
