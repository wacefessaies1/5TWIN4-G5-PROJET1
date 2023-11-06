package tn.esprit.spring.services;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Course;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class CourseServiceImplTest {
	@Autowired
	ICourseServices us;
	@Test
	@Order(1)
	public void testRetrieveAllUsers() {
	List<Course> listUsers = us.retrieveAllCourses();
	Assertions.assertEquals(0, listUsers.size());
	}
}
