package br.com.algaworks.app;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.algaworks.util.JpaUtil;
import br.com.algaworks.veiculos.dominio.Proprietario;
import br.com.algaworks.veiculos.dominio.Telefone;

public class CriaTabelas {

	public static void main(String[] args) throws IOException {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Proprietario proprietario = new Proprietario();
		proprietario.setNome("Sebastião");
		proprietario.getTelefones().add(new Telefone("34", "1234-5678", "104"));
		proprietario.getTelefones().add(new Telefone("11", "9876-5432", null));
		manager.persist(proprietario);
		tx.commit();
		manager.close();
		JpaUtil.close();
	}

}
