package br.com.proway.senior.escola.model;


import br.com.proway.senior.escola.persistence.ArrayListPersistenceProva;

public class ProvaDAO {

	ArrayListPersistenceProva db;
	
	public ProvaDAO(ArrayListPersistenceProva db) {
		this.db = db;
	}

	public void removeAll() {
		db.removeAll();
	}

	public void remove(Integer index) {
		db.remove(index);	
	}

	public Prova add(Prova prova) {
		return db.add(prova);
	}
	
	public Prova get(Integer index) {
		return db.get(index);
	}
}
