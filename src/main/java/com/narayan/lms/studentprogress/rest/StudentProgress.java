package com.narayan.lms.studentprogress.rest;

import com.narayan.lms.studentprogress.constants.AppConstants;
import com.narayan.lms.studentprogress.services.StudentProgressService;
import javassist.tools.web.BadHttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = AppConstants.ONTOLOGY_LMS_PREFIX)
public class StudentProgress {

    private static final Logger logger = LoggerFactory.getLogger(StudentProgress.class);

    @Autowired
    private StudentProgressService studentProgressService;

    @GetMapping("/student/{studentId}/{courseId}")
    public ResponseEntity<Double> getStudentProgress(@PathVariable Long studentId, @PathVariable Long courseId) {
        logger.info("Get Student Progress studentId: {}, courseId: {}", studentId, courseId);
        double percentage = studentProgressService.getStudentProgress(studentId, courseId);
        ResponseEntity<Double> respEntity = new ResponseEntity<Double>(percentage, HttpStatus.OK);

        return respEntity;

    }

}
