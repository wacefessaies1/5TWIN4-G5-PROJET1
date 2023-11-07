package tn.esprit.spring;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Piste;
import tn.esprit.spring.services.IPisteServices;

@SpringBootTest
@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
public class PisteImplTest {

	@Autowired
	IPisteServices ps;
	
	@Test
	@Order(1)
	public void testRetriveAllPistes() {
		List<Piste> listPistes = ps.retrieveAllPistes();
		Assertions.assertEquals(0, listPistes.size());
	}
}
