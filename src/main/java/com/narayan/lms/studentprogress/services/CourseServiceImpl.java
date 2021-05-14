package com.narayan.lms.studentprogress.services;

import com.narayan.lms.studentprogress.repository.CourseRepository;
import javassist.tools.web.BadHttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.NoSuchElementException;

@Service
public class CourseServiceImpl implements CourseService {

    private static final Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Integer getTotalQuestions(Long courseId) {
        int totalQuestions = 0;
        try{
             totalQuestions = courseRepository.findById(courseId).get().getTotalNumberOfQuestions();
        }catch (NoSuchElementException e){
            logger.error("Invalid courseId: {}", courseId);
            throw new IllegalArgumentException("Invalid courseId");
        }
        return totalQuestions;
    }
}
