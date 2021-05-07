package br.com.proway.senior.escola.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Reúne as {@link Prova}s de um {@link Aluno}
 * 
 *  O boletim possúi uma lista de {@link Prova}s e é referente À um periodo de 
 *  um {@link Aluno}. Para cada período é calculada a média das provas que 
 *  resulta na nota do boletim.
 *  
 *  @author Bruno Marques <brunoliveira.marques@gmail.com>.
 *
 */
public class Boletim {
	private Aluno aluno;
	private Integer periodo;
	private Double media;
	private ArrayList<Prova> provas;
	
	
	/**
	 * Cria um novo Boletim
	 * 
	 * O boletim é criado a partir de um aluno e um período. Conforme as provas
	 * são adicionadas, realiza-se o calculo, atualizando as médias.
	 * 
	 * @param aluno
	 * @param periodo
	 * @param media
	 * @param provas
	 */
	public Boletim(Aluno aluno, Integer periodo) {
		super();
		this.aluno = aluno;
		this.periodo = periodo;
		this.media = 0.0;
		this.provas = new ArrayList<Prova>();
	}

	/**
	 * Aluno do boletim
	 * 
	 */
	public Aluno getAluno() {
		return aluno;
	}

	/**
	 * Periodo no formato YYYYMM
	 */
	public Integer getPeriodo() {
		return periodo;
	}

	/**
	 *Retorna a média das provas atualizadas. 
	 */
	public Double getMedia() {
		Double soma = 0.0;
		for (int i = 0; i < this.provas.size(); i++) {
			soma = soma + this.provas.get(i).getNota();
			
		}
		return media = soma/this.provas.size();
	}

	/**
	 *Retorna todas as provas. 
	 */
	public ArrayList<Prova> getProvas() {
		return provas;
	}
	/**
	 * Ao adicionar prova a média é recalculada
	 */
	public void addProva(Prova prova) {
		this.provas.add(prova);
	}
	
	/**
	 * Remove prova do boletim
	 * Ao remover uma prova, a média é recalculada
	 */
	public void removeProva(int index) {
		this.provas.remove(index);
	}
	
	/**
	 * Remove todas as provas do boletim
	 */
	public void removeTodasProvas() {
		this.provas = new ArrayList<Prova>();

	}
	
	

}
