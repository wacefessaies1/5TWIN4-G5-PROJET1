package tn.esprit.spring.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import tn.esprit.spring.controllers.CourseRestController;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.services.ICourseServices;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseRestControllerTest {

    @InjectMocks
    private CourseRestController courseController;

    @Mock
    private ICourseServices courseServices;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddCourse() {
        Course course = new Course();
        Mockito.when(courseServices.addCourse(course)).thenReturn(course);

        ResponseEntity<Course> response = courseController.addCourse(course);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(course, response.getBody());
    }

    @Test
    public void testGetAllCourses() {
        List<Course> courses = new ArrayList<>();
        Mockito.when(courseServices.retrieveAllCourses()).thenReturn(courses);

        List<Course> response = courseController.getAllCourses();

        assertEquals(courses, response);
    }

    @Test
    public void testUpdateCourse() {
        Course course = new Course();
        Mockito.when(courseServices.updateCourse(course)).thenReturn(course);

        Course updatedCourse = courseController.updateCourse(course);

        assertEquals(course, updatedCourse);
    }

    @Test
    public void testGetCourseById() {
        Long courseId = 1L;
        Course course = new Course();
        Mockito.when(courseServices.retrieveCourse(courseId)).thenReturn(course);

        Course response = courseController.getById(courseId);

        assertEquals(course, response);
    }
}
