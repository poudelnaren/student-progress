package com.narayan.lms.studentprogress.services;

import com.narayan.lms.studentprogress.repository.StudentCourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.util.NoSuchElementException;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

    private static final Logger logger = LoggerFactory.getLogger(StudentCourseServiceImpl.class);

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @Override
    public Integer completedNumberOfQuestions(Long courseId, Long studentId) {
        int completedQuestions = 0;
        try{
            completedQuestions = studentCourseRepository.completedNumberOfQuestions(courseId, studentId);
        }catch (NoSuchElementException e){
            logger.error("Invalid studentId: {}, courseId: {}", studentId, courseId);
            throw new IllegalArgumentException("Invalid studentId or courseId");
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new RuntimeException();
        }
        return completedQuestions;
    }
}
