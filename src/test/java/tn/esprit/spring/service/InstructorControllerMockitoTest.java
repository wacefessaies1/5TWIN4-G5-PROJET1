package tn.esprit.spring.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.controllers.InstructorRestController;
import tn.esprit.spring.entities.Instructor;
import tn.esprit.spring.services.IInstructorServices;

@Slf4j
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class InstructorControllerMockitoTest {

	@Mock
    private IInstructorServices instructorServices;

    @InjectMocks
    private InstructorRestController instructorRestController;

    @Test
    public void testAddInstructor() {
    	Instructor i = new Instructor("InstMockController", "InstMockController", new Date(), null);

        Mockito.when(instructorServices.addInstructor(i)).thenReturn(i);

        Instructor addedInst = instructorRestController.addInstructor(i);

        assertSame(addedInst, i);
    }

    @Test
    public void testGetAllInstructors() {
        List<Instructor> instructors = new ArrayList<Instructor>() {
    		{
    			add(new Instructor("InstMock1Controller", "InstMock1Controller", new Date(), null));
    			add(new Instructor("InstMock2Controller", "InstMock2Controller", new Date(), null));
    		}
    	};
        Mockito.when(instructorServices.retrieveAllInstructors()).thenReturn(instructors);

        List<Instructor> instructorsRes = instructorRestController.getAllInstructors();

        assertTrue(instructors.equals(instructorsRes));
    }

    @Test
    public void testUpdateInstructor() {
    	Instructor i = new Instructor("InstMockController", "InstMockController", new Date(), null);
        Mockito.when(instructorServices.updateInstructor(i)).thenReturn(i);

        Instructor updatedInst = instructorRestController.updateInstructor(i);

        assertEquals(i, updatedInst);
    }

    @Test
    public void testGetInstructorById() {
        Long id = 1L;
        Instructor i = new Instructor();
        Mockito.when(instructorServices.retrieveInstructor(id)).thenReturn(i);

        Instructor response = instructorRestController.getById(id);

        assertEquals(i, response);
    }
    
    @Test
    public void addAndAssignToInstructorTest() {
    	Instructor i = new Instructor("InstMockController", "InstMockController", new Date(), null);
        Mockito.when(instructorServices.addInstructorAndAssignToCourse(i, 1L)).thenReturn(i);

        Instructor addedInst = instructorRestController.addAndAssignToInstructor(i, 1L);

        assertSame(addedInst, i);
    }
    
}
