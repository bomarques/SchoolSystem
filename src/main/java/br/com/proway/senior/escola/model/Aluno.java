package br.com.proway.senior.escola.model;

import Utils.Validators;

/**
 * Pessoa que estuda em uma turma, possui professor, nota, boletim e faz prova.
 * 
 * 
 * @author Bruno Marques <brunoliveira.marques@gmail.com>
 *
 */
public class Aluno {
	private String nome;
	private String sobrenome;
	private Integer idade;

	public String getNome() {
		return nome;
	}

	/**
	 * Define o primeiro nome do aluno.
	 * Utilizar apenas letras.
	 * 
	 * @throws
	 */
	public void setNome(String nomeEntrada) throws Exception {
		if (!Validators.onlyValidChars(nomeEntrada)){
			throw new Exception("Utilize apenas letras para o nome");
		} else {
			this.nome = nomeEntrada;
		}
	}

	public String getSobrenome() {
		return sobrenome;
	}

	/**
	 * Define o sobrenome do aluno.
	 * Utilizar apenas letras.
	 * 
	 * @param sobrenome
	 */
	public void setSobrenome(String sobrenomeEntrada) throws Exception {
		if(!Validators.onlyValidChars(sobrenomeEntrada)){
			throw new Exception("Utilizar apenas caracteres alfabéticos.");
		}
		this.sobrenome = sobrenomeEntrada;
	}

	public Integer getIdade() {
		return idade;
	}

	/**
	 * Define a idade do aluno.
	 * 
	 * @param idade
	 */
	public void setIdade(Integer idadeEntrada) throws Exception {
		if(idadeEntrada > 130 || idadeEntrada < 0) {
			throw new Exception ("Idade surreal");
		} else {
		this.idade = idadeEntrada;
		}
	}

}
