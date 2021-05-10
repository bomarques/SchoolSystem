package br.com.proway.senior.escola.controllers;

import br.com.proway.senior.escola.model.Prova;
import br.com.proway.senior.escola.model.ProvaDAO;
import br.com.proway.senior.escola.persistence.ArrayListPersistenceProva;

public class ProvaController {
	
	private ProvaDAO provaDao;
	private Prova prova;
	private ArrayListPersistenceProva dbProvas = new ArrayListPersistenceProva();
	
	public ProvaController(Prova prova) {
		this.provaDao = new ProvaDAO(dbProvas);		
		this.prova = prova;
	}
	
	public ProvaController(int index) {
		this.provaDao = new ProvaDAO(dbProvas);
		this.prova = provaDao.get(index);
	}
	
	/**
	 * Adiciona uma avaliaÃ§Ã£o 
	 * 
	 * @param prova
	 */
	public Prova addProva() {
		if(this.prova.getId() != null) {
			return this.provaDao.add(this.prova);	
		}
		return this.prova;
	}

	/**
	 * Remove uma avaliaÃ§Ã£o do boletim.
	 * 
	 * Ao remover a Prova, a mÃ©dia Ã© recalculada.
	 * 
	 * @param prova
	 */
	public void removeProva() {
		try{
			provaDao.remove(prova.getId());
		}catch(Exception e) {
			System.out.println("Prova não removida. Erro:" + e.getMessage());
		}
	}

	public Prova get(Integer id) {
		return this.provaDao.get(id);		
	}
}