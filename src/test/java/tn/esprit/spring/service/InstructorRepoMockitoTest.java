package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Instructor;
import tn.esprit.spring.repositories.IInstructorRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@Slf4j
public class InstructorRepoMockitoTest {

    private static final Logger log = LoggerFactory.getLogger(InstructorRepoMockitoTest.class);

    @Mock
    private IInstructorRepository instRep;

    @InjectMocks
    private InstructorRepoMockitoTest instructorRepoMockitoTest;

    private Instructor i = new Instructor("Inst2", "Inst2", new Date(), null);
    @Test
    @Order(0)
    public void testAddInstructor() {
        Mockito.when(instRep.save(Mockito.any(Instructor.class))).thenReturn(i);

        Instructor savedInstructor = instRep.save(i);

        log.info(savedInstructor.toString());

        Assertions.assertEquals(savedInstructor.getFirstName(), i.getFirstName());
    }

    @Test
    @Order(1)
    public void testRetrieveAllInstructors() {
        List<Instructor> mockList = new ArrayList<>();
        mockList.add(i);

        Mockito.when(instRep.findAll()).thenReturn(mockList);

        List<Instructor> listInstructors = instRep.findAll();

        Assertions.assertTrue(listInstructors.size() > 0);
    }

    @Test
    @Order(2)
    public void testRetrieveInstructorById() {
        Mockito.when(instRep.findById(Mockito.anyLong())).thenReturn(Optional.of(i));

        Instructor inst = instRep.findById(1L).get();

        Assertions.assertEquals(inst.getFirstName(), i.getFirstName());
    }

    @Test
    @Order(4)
    public void testUpdateInstructor() {
        Instructor updatedInstructor = new Instructor("inst1 updated", "Inst2", new Date(), null);
        Mockito.when(instRep.findById(Mockito.anyLong())).thenReturn(Optional.of(i));
        Mockito.when(instRep.save(Mockito.any(Instructor.class))).thenReturn(updatedInstructor);

        Instructor insUp = instRep.save(updatedInstructor);

        Assertions.assertTrue(insUp.getFirstName().equals("inst1 updated"));
    }

	/*@Autowired
	private IInstructorRepository instRep;
		
	Instructor i = new Instructor("Inst2", "Inst2", new Date(), null);
	
	@Test
	@Order(0)
	public void testAddInstructor() {
		i = instRep.save(i);
		log.info(i.toString());
		Assertions.assertNotNull(i.getNumInstructor());
	}
	
	@Test
	@Order(1)
	public void testRetrieveAllInstructors() {
		List<Instructor> listInstructors = instRep.findAll();
		Assertions.assertTrue(listInstructors.size()>0);
	}
	
	@Test
	@Order(2)
	public void testRetrieveInstructorById() {
		Instructor inst = instRep.findById((long) 6).get();
 		Assertions.assertEquals(inst.getFirstName(), i.getFirstName());
	}
	
	@Test
	@Order(3)
	public void testDeleteInstructor() {		
		Instructor ins = instRep.findById(3L).get();

		instRep.delete(ins);

		Instructor ins1 = null;

        Optional<Instructor> optionalInst = instRep.findById(3L);

        if(optionalInst.isPresent()){
        	ins1 = optionalInst.get();
        }

        Assertions.assertNull(ins1);
	}
	
	@Test
	@Order(4)
	public void testUpdateInstructor() {
		Instructor ins = instRep.findById(1L).get();

        ins.setFirstName("inst1 updated");

        Instructor insUp =  instRep.save(ins);

        Assertions.assertTrue(insUp.getFirstName().equals("inst1 updated"));
	}*/
}
