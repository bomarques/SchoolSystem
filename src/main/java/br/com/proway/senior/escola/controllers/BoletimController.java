package br.com.proway.senior.escola.controllers;

import java.util.ArrayList;

import br.com.proway.senior.escola.model.Boletim;
import br.com.proway.senior.escola.model.BoletimDao;
import br.com.proway.senior.escola.model.Prova;
import br.com.proway.senior.escola.persistence.ArrayListPersistenceBoletim;

public class BoletimController {
	
	Boletim boletim;
	private BoletimDao boletimDao;
	ArrayListPersistenceBoletim dbBoletim = ArrayListPersistenceBoletim.getInstance();
	public BoletimController(Boletim boletimEntrada) {
		this.boletimDao = new BoletimDao(dbBoletim);
		this.boletim = boletimEntrada;
	}
	
	public Boletim addBoletim() {
		if(this.boletim.getId() == null) {
			return this.boletimDao.add(this.boletim);	
		}
		return this.boletim;
	}
	

	/**
	 * Ao adicionar prova a média é recalculada
	 */
	public void addProva(Prova prova) {
		ProvaController provaController = new ProvaController(prova);
		if(prova.getId() != null) {
			provaController.addProva();	
		}else {
			provaController.get(prova.getId());	
		}		
		boletim.getProvas().add(prova);
		this.calcularMedia();
	}
	
	/**
	 * Remove prova do boletim
	 * Ao remover uma prova, a média é recalculada
	 */
	public void removeProva(int index) {
		ProvaController provaController = new ProvaController(index);
		provaController.removeProva();	
		try {
			boletim.getProvas().remove(index);
			this.calcularMedia();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Remove todas as provas do boletim
	 */
	public void removeTodasProvas() {
		ArrayList<Prova> provas = this.boletim.getProvas();
		
		for(Prova prova : provas) {
			ProvaController provaController = new ProvaController(prova);
			provaController.removeProva();	
		}
		this.boletim.getProvas().clear();
		this.calcularMedia();
	}
	
	
	
	public void calcularMedia(){
		int pesos = 0;
		Double soma = 0.0;
		for (int i = 0; i < boletim.getProvas().size(); i++) {
			soma = soma + (boletim.getProvas().get(i).getNota() * 
					boletim.getProvas().get(i).getPeso());
			pesos += boletim.getProvas().get(i).getPeso();
			
		}
		boletim.setMedia(soma/pesos); 
	}
	
	public Boletim getBoletim() {
		return this.boletim;
	}
	
	public ArrayList<Boletim> getAll(){
		return boletimDao.getAll();
	}

}
