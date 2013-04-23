package br.gov.serpro.agenda.business;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;
import br.gov.serpro.agenda.domain.Compromisso;

//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//import java.util.List;
//
//import javax.inject.Inject;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;
//import br.gov.serpro.compromisso.domain.Compromisso;
//
@RunWith(DemoiselleRunner.class)
public class CompromissoBCTest {

	@Inject
	private CompromissoBC compromissoBC;
	
	@Before
	public void before() {
		for (Compromisso compromisso : compromissoBC.findAll()) {
			compromissoBC.delete(compromisso.getId());
		}
	}

	@Test
	public void testLoad() {
		compromissoBC.load();
		List<Compromisso> listaCompromisso = compromissoBC.findAll();
		assertNotNull(listaCompromisso);
		assertEquals(10, listaCompromisso.size());
	}
//	
//	@Test
//	public void testInsert() {
//		Compromisso compromisso = new Compromisso();
//		compromissoBC.insert(compromisso);
//		List<compromisso> listacompromissos = compromissoBC.findAll();
//		assertNotNull(listacompromissos);
//		assertEquals(1, listacompromissos.size());
//	}
//	
//	@Test
//	public void testDelete() {
//		compromisso compromisso = new compromisso("Demoiselle Portal", "http://www.frameworkdemoiselle.gov.br");
//		compromissoBC.insert(compromisso);
//		
//		List<compromisso> listacompromissos = compromissoBC.findAll();
//		assertNotNull(listacompromissos);
//		assertEquals(1, listacompromissos.size());
//		
//		compromissoBC.delete(compromisso.getId());
//		listacompromissos = compromissoBC.findAll();
//		assertEquals(0, listacompromissos.size());
//	}
//	@Test
//	public void testUpdate() {
//		compromisso compromisso = new compromisso("Demoiselle Portal", "http://www.frameworkdemoiselle.gov.br");
//		compromissoBC.insert(compromisso);
//		
//		List<compromisso> listacompromissos = compromissoBC.findAll();
//		compromisso compromisso2 = (compromisso)listacompromissos.get(0);
//		assertNotNull(listacompromissos);
//		assertEquals("Demoiselle Portal", compromisso2.getDescription());
//		
//		compromisso2.setDescription("Demoiselle Portal alterado");
//		compromissoBC.update(compromisso2);
//		
//		listacompromissos = compromissoBC.findAll();
//		compromisso compromisso3 = (compromisso)listacompromissos.get(0);
//		assertEquals("Demoiselle Portal alterado", compromisso3.getDescription());
//	}
}
