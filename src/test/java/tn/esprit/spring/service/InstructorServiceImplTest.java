package tn.esprit.spring.service;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Instructor;
import tn.esprit.spring.services.IInstructorServices;

/*@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@Slf4j*/
public class InstructorServiceImplTest {
	
	/*private static final Logger log = LoggerFactory.getLogger(InstructorServiceImplTest.class);
	
	Instructor i = new Instructor("Inst2", "Inst2", new Date(), null);
	
	@Autowired
	private IInstructorServices instSer;
	
	@Test
	@Order(0)
	public void testUpdateInstructor() {
		instSer.updateInstructor(i);
	}
	
	@Test
	@Order(1)
	public void testAddInstructorAndAssignToCourse() {
		instSer.addInstructorAndAssignToCourse(i, (long) 1);
	}*/
}
