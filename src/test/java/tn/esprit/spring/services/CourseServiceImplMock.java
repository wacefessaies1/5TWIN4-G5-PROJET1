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

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CourseServiceImplMock {

    @Mock
    ICourseRepository courseRepository;

    @InjectMocks
    CourseServicesImpl courseservice;

    @Test
    public void testFindAllCourses() {
        // Créez un objet Course ou une liste de courses factices pour le résultat attendu

        // Définissez le comportement attendu pour le mock courseRepository, par exemple :
        List<Course> expectedCourses = new ArrayList<>();
        expectedCourses.add(new Course(1L, 0, TypeCourse.INDIVIDUAL, Support.SKI, null, 0, null));
        expectedCourses.add(new Course(2L, 0, TypeCourse.COLLECTIVE_ADULT, Support.SNOWBOARD, null, 0, null));

        Mockito.when(courseRepository.findAll()).thenReturn(expectedCourses);

        // Appelez la méthode à tester
        List<Course> actualCourses = courseservice.retrieveAllCourses();

        // Effectuez des assertions pour vérifier le comportement de la méthode
        assertEquals(expectedCourses.size(), actualCourses.size());
        // Ajoutez d'autres assertions si nécessaire pour vérifier les détails des objets Course, etc.
    }
}
