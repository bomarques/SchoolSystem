package br.com.proway.senior.escola.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlunoTest {

	@Test (expected = Exception.class)
	public void testSetNomeComNumero() throws Exception {
		Aluno aluno = new Aluno();
		aluno.setNome("Bruno123");
	}
	@Test (expected = Exception.class)
	public void testSetNomeComCaractereEspecial() throws Exception {
		Aluno aluno = new Aluno();
		aluno.setNome("Bruno.*");
	}
	
	
	@Test
	public void testSetNomeComString() {
		Aluno aluno = new Aluno();
		try {
			aluno.setNome("Bruno Marques");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertNotNull(aluno.getNome());
		
	}
	@Test (expected = Exception.class)
	public void testSeIdadeEMaiorQue130()  throws Exception{
		Aluno aluno = new Aluno();
		aluno.setIdade(135);
	}
	
	@Test
	public void testSeIdadeValida() throws Exception {
		Aluno aluno = new Aluno();
		aluno.setIdade(28);
		assertEquals(28, (int) aluno.getIdade());
	}
	
	@Test(expected = Exception.class)
	public void testSetIdadeNegativa() throws Exception{
		Aluno aluno = new Aluno();
		aluno.setIdade(-10);
	}

}
