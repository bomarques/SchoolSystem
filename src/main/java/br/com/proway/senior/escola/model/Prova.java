package br.com.proway.senior.escola.model;

/**
 * A avaliação de um aluno em uma matéria
 * 
 * A prova registra uma avaliação realizada pelo {@link Aluno} relativo ao 
 * conhecimento de uma matéria. o {@link Aluno} poderá realizar várias 
 * avaliações da mesma matéria. A média ponderada das notas das Provas é 
 * registrada no {@link Boletim} e verifica se o aluno foi aprovado.
 * 
 * @author Bruno Marques <brunoliveira.marques@gmail.com>
 * @see Aluno
 * @see Boletim
 *
 */
public class Prova {
	
	private Integer id;
	private Integer periodo;
	private Aluno aluno;
	private Materia materia;
	private Double nota = 0.0;
	private int peso = 1;
	


	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Avaliação de desempenho do aluno.
	 * 
	 * No construtor da prova não atribui-se valor para a nota, para que seja
	 * possível a criação de provas para depois serem atribuídas as notas 
	 * 
	 * @param periodo Periodo no formato YYYYMM
	 * @param aluno Aluno que realizou a prova
	 * @param materia Materia da prova
	 */
	public Prova(Integer periodo, Aluno aluno, Materia materia) {
		this.periodo = periodo;
		this.aluno = aluno;
		this.materia = materia;
	}

	/**
	 * Valor da avaliação do aluno
	 */
	public Double getNota() {
		return nota;
	}

	/**
	 * Determina avaliação do aluno.
	 * Não pode ser menor que 0, nem maior que o atributo Materia.notamaxima
	 * 
	 * @param nota
	 */
	public void setNota(Double nota) throws Exception{
		if (nota < 0 || nota > Materia.notaMaxima) {
			throw new Exception ("Nota inválida!");
		}
		this.nota = nota;
	}

	public Integer getPeriodo() {
		return periodo;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public Materia getMateria() {
		return materia;
	}
	
	public  int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	
}
