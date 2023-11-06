package tn.esprit.spring.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Course;
import tn.esprit.spring.entities.Support;
import tn.esprit.spring.entities.TypeCourse;
import tn.esprit.spring.repositories.ICourseRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CourseServiceImplMock {

    @Mock
    ICourseRepository courseRepository;

    @InjectMocks
    CourseServicesImpl courseservice;

    @BeforeEach
    public void setUp() {
        List<Course> listCourses = new ArrayList<>();
        listCourses.add(new Course(1L, 0, TypeCourse.INDIVIDUAL, Support.SKI, null, 0, null));
        listCourses.add(new Course(2L, 0, TypeCourse.COLLECTIVE_ADULT, Support.SNOWBOARD, null, 0, null));

        // Définissez le comportement attendu pour le repository mock
        Mockito.when(courseRepository.findAll()).thenReturn(listCourses);
    }
}
