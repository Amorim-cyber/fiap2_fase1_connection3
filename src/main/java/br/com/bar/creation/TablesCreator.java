package br.com.bar.creation;

import javax.persistence.Persistence;

public class TablesCreator {

	public static void main(String[] args) {
		// ATENÇÃO USAR APENAS PARA CRIAR AS TABELAS DO ZERO
		
		Persistence.createEntityManagerFactory("barproject").createEntityManager();

	}

}
