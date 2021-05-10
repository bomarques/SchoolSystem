package br.com.proway.senior.escola.controllers;

import br.com.proway.senior.escola.model.Boletim;
import br.com.proway.senior.escola.model.Prova;
import br.com.proway.senior.escola.model.ProvaDAO;

public class BoletimController {
	
	Boletim boletim;
	
	public BoletimController(Boletim boletimEntrada) {
		this.boletim = boletimEntrada;
	}
	

	/**
	 * Ao adicionar prova a média é recalculada
	 */
	public void addProva(Prova prova) {
		ProvaDAO provaDao = new ProvaDAO(boletim);
		provaDao.add(prova);
		this.calcularMedia();

	}
	
	/**
	 * Remove prova do boletim
	 * Ao remover uma prova, a média é recalculada
	 */
	public void removeProva(int index) {
		try {
		ProvaDAO provaDao = new ProvaDAO(boletim);
		provaDao.remove(index);
		} catch (Exception e) {
			System.out.println("Prova não removida. Erro:" + e.getMessage());
		}
		this.calcularMedia();
	}
	
	/**
	 * Remove todas as provas do boletim
	 */
	public void removeTodasProvas() {
		ProvaDAO provaDao = new ProvaDAO(boletim);
		provaDao.removeAll();
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

}
