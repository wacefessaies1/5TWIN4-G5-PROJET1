package tn.esprit.spring.services;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.repositories.ICourseRepository;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CourseServiceImplMock {
	@Mock
	ICourseRepository courseRepository;
	// Ou
	@InjectMocks
	CourseServicesImpl courseservice;
}
