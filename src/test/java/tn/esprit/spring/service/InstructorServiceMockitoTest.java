package tn.esprit.spring.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Instructor;
import tn.esprit.spring.repositories.IInstructorRepository;
import tn.esprit.spring.services.InstructorServicesImpl;

@Slf4j
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class InstructorServiceMockitoTest {
	
	private static final Logger log = LoggerFactory.getLogger(InstructorServiceMockitoTest.class);

	//pour isoler la dépendence entre les classes service et repo = pas de cnx avec BD pour plus de rapidité
	@Mock
	IInstructorRepository instRep;
	
	//injection du mock dans la classe service à tester
	@InjectMocks
	InstructorServicesImpl instSer;
	
	Instructor i = new Instructor("InstMock", "InstMock", new Date(), null);
	
	List<Instructor> list = new ArrayList<Instructor>() {
		{
			add(new Instructor("InstMock1", "InstMock1", new Date(), null));
			add(new Instructor("InstMock2", "InstMock2", new Date(), null));
		}
	};
	
	//ajout sans la BD
	@Test
	public void addInstructorTest() {
		Mockito.when(instRep.save(Mockito.any(Instructor.class))).then(invocation -> {
			Instructor inst = invocation.getArgument(0, Instructor.class);
			inst.setNumInstructor((long) 6);
			return inst;
		});
		
		log.info("Before adding : " + i.toString());
		Instructor instructor = instSer.addInstructor(i);
		assertSame(instructor, i);
		log.info("After adding : " + i.toString());
	}
	
	@Test
	public void retreiveInstructorTest() {
		Mockito.when(instRep.findById(Mockito.anyLong())).thenReturn(Optional.of(i));
		Instructor instructor = instSer.retrieveInstructor((long) 5);
		assertNotNull(instructor);
		log.info("Instructor : " + instructor.toString());
		verify(instRep).findById(Mockito.anyLong());
	}
	
	@Test
	public void retreiveAllInstructorTest() {
		Mockito.when(instRep.findAll()).thenReturn(list);
		List<Instructor> instructors = instSer.retrieveAllInstructors();
		assertNotNull(instructors);
	}
	
	@Test
    public void updateInstructorTest() {
		Mockito.when(instRep.save(Mockito.any(Instructor.class))).thenReturn(i);
		Instructor updatedInstructor = instSer.updateInstructor(i);
        assertNotNull(updatedInstructor);
        verify(instRep).save(Mockito.any(Instructor.class));
    }
	
}
