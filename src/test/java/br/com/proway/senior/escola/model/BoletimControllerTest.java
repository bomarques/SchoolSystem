package br.com.proway.senior.escola.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.proway.senior.escola.controllers.BoletimController;
import br.com.proway.senior.escola.persistence.ArrayListPersistenceBoletim;

public class BoletimControllerTest {
	
	static BoletimController controller;
	static BoletimController controller2;
	static ArrayListPersistenceBoletim dbBoletim = ArrayListPersistenceBoletim.getInstance();
	private static int periodoPadrao = 202105; 

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Aluno aluno = new Aluno();
		Integer periodo = periodoPadrao;
		Boletim boletim = new Boletim(aluno, periodo);
		Boletim boletim2 = new Boletim(aluno, periodo);
		controller = new BoletimController(boletim);
		controller2 = new BoletimController(boletim2);
		
	}

	@Test
	public void testBoletim() {
		assertNotNull(controller.getBoletim());
	}

	@Test
	public void testGetAluno() {
		assertNotNull(controller.getBoletim().getAluno());
	}

	@Test
	public void testGetPeriodo() {
		assertNotNull(controller.getBoletim().getAluno());
	}

	@Test
	public void testCalcularMedia() {
		controller.removeTodasProvas();
		Materia materia = new Materia();
		Prova prova = new Prova(periodoPadrao, controller.getBoletim().getAluno(), materia);
		Prova prova2 = new Prova(periodoPadrao, controller.getBoletim().getAluno(), materia);
		Prova prova3 = new Prova(periodoPadrao, controller.getBoletim().getAluno(), materia);

		try {
			prova.setNota(10.0);
			prova2.setNota(8.0);
			prova3.setNota(6.0);
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		controller.addProva(prova);
		controller.addProva(prova2);
		controller.addProva(prova3);

		assertEquals(8.0, controller.getBoletim().getMedia(), 0.01);
	}

	@Test
	public void testAddProva() {
		controller.removeTodasProvas();
		Materia materia = new Materia();
		Prova prova = new Prova(periodoPadrao, controller.getBoletim().getAluno(), materia);
		controller.addProva(prova);
		assertEquals(1,(int) controller.getBoletim().getProvas().size());
	}

	@Test
	public void testRemoveProva() {
		Materia materia = new Materia();
		Prova prova = new Prova(periodoPadrao, controller.getBoletim().getAluno(), materia);
		controller.removeTodasProvas();
		controller.addProva(prova);
		controller.addProva(prova);
		controller.removeProva(0);
		assertEquals(1, controller.getBoletim().getProvas().size());
			}
	
	@Test
	public void testRemoveTodasProvas() {
		Materia materia = new Materia();
		Prova prova = new Prova(periodoPadrao, controller.getBoletim().getAluno(), materia);

		controller.addProva(prova);
		controller.removeTodasProvas();
		assertFalse(controller.getBoletim().getProvas().size() > 0);
	}
	
	@Test
	public void testRemoveProvaInexistente() {
		Materia materia = new Materia();
		Boletim boletim = controller.getBoletim();
		Prova prova = new Prova(202105, boletim.getAluno(), materia);

		controller.removeTodasProvas();
		controller.addProva(prova);
		controller.addProva(prova);
		controller.removeProva(4);
		assertEquals(2, boletim.getProvas().size());
	}
	
	@Test
	public void testAddDoisBoletins() {
		Materia materia = new Materia();
		Boletim boletim = controller.getBoletim();
		Boletim boletim2 = controller2.getBoletim();
		Prova prova = new Prova(202105, boletim.getAluno(), materia);
		
		controller.addProva(prova);
		controller.addBoletim();
		
		Prova prova2 = new Prova(202105, boletim2.getAluno(), materia);
		
		controller2.addProva(prova2);
		controller2.addBoletim();
		
		assertEquals(2, controller.getAll().size()); 
	}

}
