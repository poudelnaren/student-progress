package com.narayan.lms.studentprogress.services;

import javassist.tools.web.BadHttpRequest;
import org.springframework.stereotype.Service;

public interface StudentProgressService {

    double getStudentProgress(Long studentId, Long courseId);
}
