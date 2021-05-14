package com.narayan.lms.studentprogress.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.NoSuchElementException;

@RunWith(MockitoJUnitRunner.class)
public class StudentProgressServiceImplTest {

    @InjectMocks
    private StudentProgressServiceImpl studentProgressService;

    @Mock
    private CourseService courseService;

    @Mock
    private StudentCourseService studentCourseService;

    @Test
    public void testValidCourseIdStudentId(){

        Mockito.when(courseService.getTotalQuestions(Mockito.anyLong())).thenReturn(10);
        Mockito.when(studentCourseService.completedNumberOfQuestions(Mockito.anyLong(), Mockito.anyLong())).thenReturn(8);
        Assert.assertEquals(studentProgressService.getStudentProgress(1L, 2L), 20.0, 0);
    }

    @Test(expected = NoSuchElementException.class)
    public void testInvalidCourseId(){
        Mockito.when(courseService.getTotalQuestions(Mockito.anyLong())).thenThrow(new NoSuchElementException());
        studentProgressService.getStudentProgress(1L, 2L);
    }

    @Test(expected = NoSuchElementException.class)
    public void testInvalidStudentId(){
        Mockito.when(studentCourseService.completedNumberOfQuestions(Mockito.anyLong(), Mockito.anyLong())).thenThrow(new NoSuchElementException());
        studentProgressService.getStudentProgress(1L, 2L);
    }

}